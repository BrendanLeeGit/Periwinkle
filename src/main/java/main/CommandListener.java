package main;

import commands.Command;
import commands.Invoker;
import commands.RegisterUserCommand;
import commands.SendScreenShotCommand;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import receivers.GeneralReceiver;

/**
 * main.Main listener, especially for Guild messages.
 */
public class CommandListener extends ListenerAdapter {
    private final char commandChar;
    private final MessageChannelTracker messageChannelTracker;
    private MessageReceivedEvent currentMessageEvent;
    private Invoker invoker;

    public CommandListener(char commandChar){
        this.commandChar = commandChar;
        messageChannelTracker = new MessageChannelTracker();
        prepareCommands();
    }

    public CommandListener(){
        commandChar = '&';
        messageChannelTracker = new MessageChannelTracker();
        prepareCommands();
    }

    private void prepareCommands(){
        GeneralReceiver receiver = new GeneralReceiver(messageChannelTracker);

        Command sendScreenShotCommand = new SendScreenShotCommand(receiver);
        Command registerUserCommand = new RegisterUserCommand(receiver);

        invoker = new Invoker();
        invoker.register("SendScreenshot", sendScreenShotCommand);
        invoker.register("RegisterUser", registerUserCommand);
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        processMessage(event);
    }

    private void processMessage(MessageReceivedEvent event) {
        //Keep a reference to the event, and record the current channel in the channel tracker
        currentMessageEvent = event;
        messageChannelTracker.setCurrentMessageChannel(event.getChannel());

        //Gather the input from the event and strip it of extra content
        Message message = event.getMessage();
        String[] input = message.getContentStripped().split(" ");

        //If the input is acceptable, process it through the different commands
        if (isAcceptableInput(input)){
            invoker.execute(input);
        }
    }

    /**
     * Checks the validity of the input. Ensures that the command
     * character is present, as well as any other needed validation.
     * @param input The inputted command
     * @return      whether the input is valid or not
     */
    public boolean isAcceptableInput(String[] input){
        //Ensure the first char is the command char and the messenger isn't a bot
        return (input[0].charAt(0) == commandChar && !currentMessageEvent.getAuthor().isBot());
    }
}
