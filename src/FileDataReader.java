import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileDataReader implements OperationsProvidable {
    private String inputFilePath;

    public String getInputFilePath() {
        return inputFilePath;
    }

    public void setInputFilePath(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public Operations getOperation() {
        CommandChecker commandChecker = new CommandChecker();
        boolean isCorrectInput = false;

        File file = new File(inputFilePath);

        if (!file.exists() || file.isDirectory()) {
            Messages.printFileNotFound(inputFilePath);
            System.exit(0);
        }

        if (file.length() == 0) {
            Messages.printFileIsEmpty(inputFilePath);
            System.exit(0);
        }

        String text = null;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath))) {
            text = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        commandChecker.setCommand(text);

        Operations o = null;

        if (commandChecker.isCommandValid()) {
            o = Operations.getByName(commandChecker.getOperation());
        } else {
            Messages.printFileNotCorrect();
            System.exit(0);
        }

        if (o != null) {
            o.setNumbers(commandChecker.getNumbers());
        }

        return o;
    }
}