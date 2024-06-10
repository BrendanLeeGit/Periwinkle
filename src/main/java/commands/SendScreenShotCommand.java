package commands;

import receivers.Receiver;

public class SendScreenShotCommand implements Command {
    private final Receiver receiver;

    public SendScreenShotCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.sendScreenShot();
    }
}