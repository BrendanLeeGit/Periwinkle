package receivers;

import main.MessageChannelTracker;
import main.ScreenshotTaker;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.utils.FileUpload;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

public class GeneralReceiver {
    private final MessageChannelTracker messageChannelTracker;

    public GeneralReceiver(MessageChannelTracker messageChannelTracker){
        this.messageChannelTracker = messageChannelTracker;
    }

    public void sendHelpMessage(){
        messageChannelTracker.getCurrentMessageChannel().sendMessage("""
                The available commands are as follows:
                Help
                RegisterUser
                SendScreenshot
                ShutDownPC
                TurnOffBot
                """).queue();
    }

    public void registerUser() {
        //TODO: implement
        System.out.println("user registering?");
        messageChannelTracker.addCurrentMessageChannelToMessageChannels();

        //TODO: Remove print line
        System.out.println(messageChannelTracker.getCurrentMessageChannel().toString());
    }

    public void sendScreenShot() {
        ScreenshotTaker screenshotTaker = new ScreenshotTaker();
        screenshotTaker.takeScreenShot();

        MessageEmbed embed = new EmbedBuilder()
                .setDescription("Here's your current screen :)")
                .setImage("attachment://screenshot.png")
                .build();

        FileUpload file = FileUpload.fromData(new File("screenshot.png"), "screenshot.png");
        messageChannelTracker.getCurrentMessageChannel().sendFiles(Collections.singleton(file))
                .addEmbeds(embed)
                .queue();

    }

    public void shutDownPC(){
        try {
            Runtime r = Runtime.getRuntime();
            r.exec("shutdown -s -t " + 10);
        } catch (NumberFormatException | IOException e) {
            messageChannelTracker.getCurrentMessageChannel().sendMessage("Shutdown failed.").queue();
        }
    }

    public void turnOffBot(){
        System.exit(0);
    }
}