package commands;

/**
 * Serves as an interface for all commands, so they can be stored together
 * and executed the same way.
 */
public interface Command {
    void execute(String[] inputtedCommand);
}
