import java.io.*;

public class CalculateProgram {
    public static void run(String[] args) {
        ArgsHandler.setArgs(args);
        OperationsProvidable operationsProvidable = null;

        if (ArgsHandler.isConsoleRunArgs()) {
            operationsProvidable = new ConsoleDataReader();
        } else {
            if (ArgsHandler.isInputFileExist()) {
                operationsProvidable = new FileDataReader();
                ((FileDataReader) operationsProvidable).setInputFilePath(ArgsHandler.getInputFilePath());
            } else {
                Messages.printFileNotFound(args[0]);
                System.exit(0);
            }
        }

        resultOutput(operationsProvidable);
    }

    private static void resultOutput(OperationsProvidable operationsProvidable) {
        if (ArgsHandler.isConsoleRunArgs()) {
            System.out.println("Ответ: " + operationsProvidable.getOperation().getCalculationResult());
        } else {
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ArgsHandler.getOutputFilePath())))) {
                writer.write(operationsProvidable.getOperation().getCalculationResult().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}