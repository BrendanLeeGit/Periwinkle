package commands;

/**
 * Serves as an interface for all commands, so each can be stored with all the others and executed the same way.
 */
public interface Command {
    void execute();
}
