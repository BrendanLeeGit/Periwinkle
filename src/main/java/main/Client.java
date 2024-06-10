package main;

import commands.*;
import receivers.Receiver;

/**
 * This is just an example of working all of the commands.Command pattern together. Will not be used.
 */
public class Client {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();

        Command startCommand = new StartCommand(receiver);
        Command stopCommand = new StopCommand(receiver);

        Invoker invoker = new Invoker();
        invoker.register("start", startCommand);
        invoker.register("stop", stopCommand);

        invoker.execute("start");
        invoker.execute("stop");
        invoker.execute("unknown");
    }
}