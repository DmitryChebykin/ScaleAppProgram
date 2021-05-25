package controller.receiver;

import controller.IDataReceiver;
import producer.Operations;

public abstract class DataReceiver implements IDataReceiver {
    @Override
    public Operations getOperation() {
        return null;
    }
}