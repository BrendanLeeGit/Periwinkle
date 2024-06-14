package commands;

import receivers.GeneralReceiver;

public class SendScreenshotCommand implements Command {
    private final GeneralReceiver receiver;

    public SendScreenshotCommand(GeneralReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String[] inputtedCommand) {
        receiver.sendScreenShot();
    }
}