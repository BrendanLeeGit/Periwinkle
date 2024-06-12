package commands;

import receivers.GeneralReceiver;

public class TurnOffBotCommand implements Command {
    private final GeneralReceiver receiver;

    public TurnOffBotCommand(GeneralReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String[] inputtedCommand) {
        receiver.turnOffBot();
    }
}