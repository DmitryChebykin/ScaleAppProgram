package producer;

import util.Messages;

public class HelpContext implements IContext {
    @Override
    public void run() {
        Messages.printHelpInfo();
    }
}