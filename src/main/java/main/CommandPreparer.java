package main;

import commands.*;
import receivers.GeneralReceiver;

public class CommandPreparer {
    private MessageChannelTracker messageChannelTracker;
    private Invoker invoker;
    private GeneralReceiver receiver;

    public CommandPreparer(MessageChannelTracker messageChannelTracker){
        this.messageChannelTracker = messageChannelTracker;
        invoker = new Invoker();
    }

    public void prepareCommands(){
        generateReceivers();
        registerCommands();
    }

    private void generateReceivers(){
        receiver = new GeneralReceiver(messageChannelTracker);
    }

    private void registerCommands(){
        invoker.registerCommand("Help", new HelpCommand(receiver));
        invoker.registerCommand("SendScreenshot", new SendScreenshotCommand(receiver));
        invoker.registerCommand("ShutDownPC", new ShutDownPCCommand(receiver));
        invoker.registerCommand("RegisterUser", new RegisterUserCommand(receiver));
        invoker.registerCommand("TurnOffBot", new TurnOffBotCommand(receiver));
    }

    public void processInputtedCommand(String[] input){
        invoker.executeCommand(input);
    }
}
