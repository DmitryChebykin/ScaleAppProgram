import java.io.File;

public class ArgsHandler {
    private static final char CONSOLE_RUN_ARGS_KEY = '-';

    private static String[] args;

    public static String getInputFilePath() {
        return args[0];
    }

    public static String getOutputFilePath() {
        return args[1];
    }

    public static boolean isConsoleRunArgs() {
        return (args[0].charAt(0) == CONSOLE_RUN_ARGS_KEY);
    }

    public static boolean isInputFileExist() {
        File file = new File(args[0]);
        return file.exists() && file.length() != 0;
    }

    public static String[] getArgs() {
        return args;
    }

    public static void setArgs(String[] args) {
        ArgsHandler.args = args;
    }
}