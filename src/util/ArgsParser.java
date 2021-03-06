package util;

import producer.CalcContext;
import producer.IContext;
import controller.IDataReceiver;
import controller.IDataSender;
import controller.receiver.ConsoleDataReader;
import controller.receiver.OneLineFileDataReader;
import controller.sender.ConsoleDataSender;
import controller.sender.OneLineFileDataSender;
import producer.HelpContext;
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
        if (args[0].equals("/?")) {
            return new HelpContext();
        }

        if (args.length < 2) {
            Messages.printWrongArgs();
            return null;
        }

        IDataReceiver receiver;
        IDataSender sender;

        if (args[0].charAt(0) == CONSOLE_RUN_ARGS_KEY) {
            receiver = new ConsoleDataReader();
        } else {
            receiver = new OneLineFileDataReader();

            if (isInputFileExist()) {
                ((OneLineFileDataReader) receiver).setFilePath(args[0]);
            } else {
                Messages.printFileNotFound(args[0]);

                return null;
            }
        }

        if (args[1].charAt(0) == CONSOLE_RUN_ARGS_KEY) {
            sender = new ConsoleDataSender();
        } else {
            sender = new OneLineFileDataSender();
            ((OneLineFileDataSender) sender).setFilePath(args[1]);
        }

        return new CalcContext(receiver, sender);
    }
}