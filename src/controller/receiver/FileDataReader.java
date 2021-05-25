package controller.receiver;

import producer.Operations;
import util.CommandChecker;
import util.Messages;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileDataReader extends DataReceiver {
    private String inputFilePath;

    public String getInputFilePath() {
        return inputFilePath;
    }

    public void setFilePath(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public Operations getOperation() {
        CommandChecker commandChecker = new CommandChecker();

        File file = new File(inputFilePath);

        if (!file.exists() || file.isDirectory()) {
            Messages.printFileNotFound(inputFilePath);
            return null;
        }

        if (file.length() == 0) {
            Messages.printFileIsEmpty(inputFilePath);
            return null;
        }

        String text = null;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath))) {
            text = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        commandChecker.setCommand(text);

        Operations o;

        if (commandChecker.isCommandValid()) {
            o = Operations.getByName(commandChecker.getOperation());
        } else {
            Messages.printFileNotCorrect();
            return null;
        }

        if (o != null) {
            o.setNumbers(commandChecker.getNumbers());
        }

        return o;
    }
}