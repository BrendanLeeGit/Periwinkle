package main;

import commands.Invoker;
import commands.RegisterUserCommand;
import commands.ShutDownPCCommand;
import commands.SendScreenShotCommand;
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
        invoker.registerCommand("SendScreenshot", new SendScreenShotCommand(receiver));
        invoker.registerCommand("RegisterUser", new RegisterUserCommand(receiver));
        invoker.registerCommand("ShutDownPC", new ShutDownPCCommand(receiver));
    }

    public void processInputtedCommand(String[] input){
        invoker.executeCommand(input);
    }
}
