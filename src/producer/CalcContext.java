package producer;

import controller.IDataReceiver;
import controller.IDataSender;

public class CalcContext implements IContext {
    private IDataReceiver dataReceiver;
    private IDataSender dataSender;

    public CalcContext(IDataReceiver dataReceiver, IDataSender dataSender) {
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
            dataSender.setResult(o.getResult().toString());
            dataSender.sendResult();
        }
    }
}