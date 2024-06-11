package main;

import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

import java.util.ArrayList;

public class MessageChannelTracker {
    private final ArrayList<MessageChannel> messageChannels;
    private MessageChannel currentMessageChannel;

    public MessageChannelTracker(){
        messageChannels = new ArrayList<>();
    }

    public void setCurrentMessageChannel(MessageChannel messageChannel){
        currentMessageChannel = messageChannel;
    }

    public MessageChannel getCurrentMessageChannel(){
        return currentMessageChannel;
    }

    public void addToMessageChannels(MessageChannel inputtedMessageChannel){
        messageChannels.add(inputtedMessageChannel);
    }

    public void addCurrentMessageChannelToMessageChannels(){
        messageChannels.add(currentMessageChannel);
    }
}
