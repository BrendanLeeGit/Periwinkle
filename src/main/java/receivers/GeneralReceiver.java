package receivers;

import main.MessageChannelTracker;

public class GeneralReceiver {
    private final MessageChannelTracker messageChannelTracker;

    public GeneralReceiver(MessageChannelTracker messageChannelTracker){
        this.messageChannelTracker = messageChannelTracker;
    }

    public void sendScreenShot() {
        //TODO: implement
        System.out.println("sending screenshot?");
    }

    public void registerUser() {
        //TODO: implement
        System.out.println("user registering?");
        messageChannelTracker.addCurrentMessageChannelToMessageChannels();

        //TODO: Remove print line
        System.out.println(messageChannelTracker.getCurrentMessageChannel().toString());
    }
}