package commands;

import receivers.Receiver;

public class StopCommand implements Command {
    private Receiver receiver;

    public StopCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.stop();
    }
}