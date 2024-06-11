package commands;

import receivers.GeneralReceiver;

public class SendScreenShotCommand implements Command {
    private final GeneralReceiver receiver;

    public SendScreenShotCommand(GeneralReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String[] inputtedCommand) {
        receiver.sendScreenShot();
    }
}