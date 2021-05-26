package controller.receiver;

import producer.Operations;
import util.CommandChecker;
import util.Messages;
import java.util.Scanner;

public class ConsoleDataReader extends DataReceiver {

    public Operations getOperation() {
        CommandChecker commandChecker = new CommandChecker();

        Scanner scanner = new Scanner(System.in);

        boolean isCorrectInput = false;

        while (!isCorrectInput) {
            Messages.printConsoleInputMessage();
            String command = scanner.nextLine();

            if (command.equals(Messages.EXIT_COMMAND)) {
                return null;
            }

            commandChecker.setCommand(command);

            isCorrectInput = commandChecker.isCommandValid();

            if (!isCorrectInput) {
                Messages.printWrongInputMessage();
            }
        }

        Operations o = Operations.getByName(commandChecker.getOperation());

        if (o != null) {
            o.setNumbers(commandChecker.getNumbers());
        }

        return o;
    }
}