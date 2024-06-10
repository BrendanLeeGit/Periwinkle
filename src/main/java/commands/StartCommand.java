package commands;

import receivers.Receiver;

public class StartCommand implements Command {
    private Receiver receiver;

    public StartCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.start();
    }
}