package commands;

import receivers.GeneralReceiver;

public class HelpCommand implements Command {
    private final GeneralReceiver receiver;

    public HelpCommand(GeneralReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String[] inputtedCommand) {
        receiver.sendHelpMessage();
    }
}