package controller.receiver;

import producer.Operations;
import util.CommandChecker;
import java.util.Scanner;

public class ConsoleDataReader extends DataReceiver {
    public Operations getOperation() {
        CommandChecker commandChecker = new CommandChecker();
        boolean isCorrectInput = false;
        Scanner scanner = new Scanner(System.in);

        while (!isCorrectInput) {
            System.out.println("Введите команду и набор чисел:");
            commandChecker.setCommand(scanner.nextLine());
            System.out.println();
            isCorrectInput = commandChecker.isCommandValid();

            if (!isCorrectInput) {
                System.out.println("Неверный ввод, попробуйте снова!");
            }
        }

        Operations o = Operations.getByName(commandChecker.getOperation());

        if (o != null) {
            o.setNumbers(commandChecker.getNumbers());
        }

        return o;
    }
}