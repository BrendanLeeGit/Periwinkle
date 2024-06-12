package commands;

import receivers.GeneralReceiver;

public class ShutDownPCCommand implements Command {
    private final GeneralReceiver receiver;

    public ShutDownPCCommand(GeneralReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String[] inputtedCommand) {
        receiver.shutDownPC();
    }
}