package receivers;

import main.MessageChannelTracker;
import main.ScreenshotTaker;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.utils.FileUpload;

import java.io.File;
import java.util.Collections;

public class GeneralReceiver {
    private final MessageChannelTracker messageChannelTracker;

    public GeneralReceiver(MessageChannelTracker messageChannelTracker){
        this.messageChannelTracker = messageChannelTracker;
    }

    public void sendScreenShot() {
        ScreenshotTaker screenshotTaker = new ScreenshotTaker();
        screenshotTaker.takeScreenShot();

        MessageEmbed embed = new EmbedBuilder()
                .setDescription("Here's your current screen :)")
                .setImage("attachment://screenshot.png") // refer to the file by using the "attachment://" schema with the filename we gave it above
                .build();

        FileUpload file = FileUpload.fromData(new File("screenshot.png"), "screenshot.png");
        messageChannelTracker.getCurrentMessageChannel().sendFiles(Collections.singleton(file)) // send the file upload
                .addEmbeds(embed) // add the embed you want to reference the file with
                .queue();

    }

    public void registerUser() {
        //TODO: implement
        System.out.println("user registering?");
        messageChannelTracker.addCurrentMessageChannelToMessageChannels();

        //TODO: Remove print line
        System.out.println(messageChannelTracker.getCurrentMessageChannel().toString());
    }
}