import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.FileNotFoundException;

/**
 * Main listener, especially for Guild messages.
 */
public class CommandListener extends ListenerAdapter {
    private char commandChar;

    public CommandListener(char commandChar){
        this.commandChar = commandChar;
    }

    public CommandListener(){
        commandChar = '&';
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;              //Make sure bots can't prompt Mango

        //Check input for the command character and then remove it from the command string
        Message message = event.getMessage();

        String input = message.getContentStripped();
        //For some reason need to make sure it's not empty ig??
        if (input.length() == 0){
            return;
        }

        if (input.charAt(0) == commandChar){                //Check if the command character is present
            input = input.substring(1);           //Cut off the command char
        }
        else {
            //If the command char isn't present, do nothing with it
            return;
        }

        System.out.println(input);
    }
}
