import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.FileNotFoundException;

/**
 * Main listener, especially for Guild messages.
 */
public class CommandListener extends ListenerAdapter {
    private final char commandChar;
    private MessageReceivedEvent currentMessageEvent;

    public CommandListener(char commandChar){
        this.commandChar = commandChar;
    }

    public CommandListener(){
        commandChar = '&';
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        //Keep a reference to the event
        currentMessageEvent = event;

        //Gather the input from the event and strip it of extra content
        Message message = event.getMessage();
        String input = message.getContentStripped();

        //If the input is acceptable, process it through the different commands
        if (isAcceptableInput(input)){
            //TODO: Process commands through
            //TODO: Utilize the Invoker to execute commands
        }
    }

    /**
     * Checks the validity of the input. Ensures that the command
     * character is present, as well as any other needed validation.
     * @param input The inputted command
     * @return      whether the input is valid or not
     */
    public boolean isAcceptableInput(String input){
        //Ensure the first char is the command char and the messenger isn't a bot
        return (input.charAt(0) == commandChar && !currentMessageEvent.getAuthor().isBot());
    }
}
