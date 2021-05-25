package producer;

import util.ArgsParser;

public class Application {
    public static void run(String[] args) {
        ArgsParser.setArgs(args);
        IContext context = ArgsParser.getContext();
        if (context != null) {
            context.run();
        }
    }
}