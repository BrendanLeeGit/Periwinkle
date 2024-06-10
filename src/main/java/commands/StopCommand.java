package commands;

import receivers.Receiver;

public class StopCommand implements Command {
    private final Receiver receiver;

    public StopCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        //receiver.stop();
    }
}