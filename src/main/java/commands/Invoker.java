package commands;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is used to register commands and execute them.
 */
public class Invoker {
    private final Map<String, Command> commandsMap = new HashMap<>();

    /**
     * Registers a command into the commandMap.
     * @param commandName   The name of the command that the user sees
     * @param command       The command itself that can be executed
     */
    public void registerCommand(String commandName, Command command) {
        commandsMap.put(commandName, command);
    }

    /**
     * Locates the command in the commandsMap and executes it.
     * If the inputted command doesn't exist, the Unknown command will be executed instead.
     * @param inputtedCommand   The input to be interpreted as a command
     */
    public void executeCommand(String[] inputtedCommand) {
        //The second index holds the name of the command as per the format
        Command command = commandsMap.get(inputtedCommand[1]);
        if (command != null) {
            command.execute(inputtedCommand);
        } else {
            System.out.println("Unknown command");
        }
    }
}