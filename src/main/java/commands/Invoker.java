package commands;

import java.util.HashMap;
import java.util.Map;

public class Invoker {
    private final Map<String, Command> commandMap = new HashMap<>();

    public void register(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    public void execute(String[] inputtedCommand) {
        //The second index holds the name of the command as per the format
        Command command = commandMap.get(inputtedCommand[1]);
        if (command != null) {
            command.execute(inputtedCommand);
        } else {
            System.out.println("Unknown command");
        }
    }
}