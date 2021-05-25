package controller;

import producer.Operations;

public class Context implements IContext {
    private IDataReceiver dataReceiver;
    private IDataSender dataSender;

    public Context(IDataReceiver dataReceiver, IDataSender dataSender) {
        this.dataReceiver = dataReceiver;
        this.dataSender = dataSender;
    }

    public IDataReceiver getDataReceiver() {
        return dataReceiver;
    }

    public void setDataReceiver(IDataReceiver dataReceiver) {
        this.dataReceiver = dataReceiver;
    }

    public IDataSender getDataSender() {
        return dataSender;
    }

    public void setDataSender(IDataSender dataSender) {
        this.dataSender = dataSender;
    }

    @Override
    public void run() {
        Operations o = dataReceiver.getOperation();
        if (o != null) {
            dataSender.setResult(o.getCalculationResult().toString());
            dataSender.sendResult();
        }
    }
}