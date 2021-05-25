package util;

import controller.Context;
import controller.IContext;
import controller.IDataReceiver;
import controller.IDataSender;
import controller.receiver.ConsoleDataReader;
import controller.receiver.FileDataReader;
import controller.sender.ConsoleDataSender;
import controller.sender.FileDataSender;
import java.io.File;

public class ArgsParser {
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
        ArgsParser.args = args;
    }

    public static IContext getContext() {
        if (args.length < 2) {
            Messages.printWrongArgs();
            return null;
        }

        IDataReceiver receiver;
        IDataSender sender;

        if (args[0].charAt(0) == CONSOLE_RUN_ARGS_KEY) {
            receiver = new ConsoleDataReader();
        } else {
            receiver = new FileDataReader();

            if (isInputFileExist()) {
                ((FileDataReader) receiver).setFilePath(args[0]);
            } else {
                Messages.printFileNotFound(args[0]);

                return null;
            }
        }

        if (args[1].charAt(0) == CONSOLE_RUN_ARGS_KEY) {
            sender = new ConsoleDataSender();
        } else {
            sender = new FileDataSender();
            ((FileDataSender) sender).setFilePath(args[1]);
        }

        return new Context(receiver, sender);
    }
}