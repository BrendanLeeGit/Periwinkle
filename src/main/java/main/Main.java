package main;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        //Read the key from the key.txt file and start up the bot
        try (BufferedReader br = new BufferedReader(new FileReader("key.txt"))){
            JDA api =
                    JDABuilder.createDefault(br.readLine()).
                            addEventListeners(new CommandListener()).
                            enableIntents(GatewayIntent.MESSAGE_CONTENT).
                            build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
