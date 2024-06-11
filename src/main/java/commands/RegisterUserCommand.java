package commands;

import receivers.GeneralReceiver;

public class RegisterUserCommand implements Command {
    private final GeneralReceiver receiver;

    public RegisterUserCommand(GeneralReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String[] inputtedCommand) {
        receiver.registerUser();
    }
}