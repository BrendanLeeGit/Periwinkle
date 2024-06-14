package main;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

/**
 * main.Main listener, especially for Guild messages.
 */
public class CommandListener extends ListenerAdapter {
    private final char commandChar;
    private final MessageChannelTracker messageChannelTracker;
    private MessageReceivedEvent currentMessageEvent;
    private final CommandPreparer commandPreparer;

    public CommandListener(){
        commandChar = '&';
        messageChannelTracker = new MessageChannelTracker();
        commandPreparer = new CommandPreparer(messageChannelTracker);
        prepareCommands();
    }

    private void prepareCommands(){
        commandPreparer.prepareCommands();
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        processMessage(event);
    }

    private void processMessage(MessageReceivedEvent event) {
        //Keep a reference to the event, and record the current channel in the channel tracker
        currentMessageEvent = event;
        messageChannelTracker.setCurrentMessageChannel(event.getChannel());

        //We split the input into a String[] where anything at [2] and onward is a parameter for the command
        Message message = event.getMessage();
        String[] input = message.getContentStripped().split(" ");

        //If the input is acceptable, process it through the different commands
        if (isAcceptableInput(input)){
            commandPreparer.processInputtedCommand(input);
        }
    }

    /**
     * Checks the validity of the input. Ensures that the command
     * character is present, as well as any other needed validation.
     * @param input The inputted command
     * @return      whether the input is valid or not
     */
    public boolean isAcceptableInput(String[] input){
        if (input == null || currentMessageEvent.getAuthor().isBot()){
            return false;
        }
        return (input[0].charAt(0) == commandChar);
    }
}
