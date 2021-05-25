package controller.sender;

import controller.IDataSender;

public class ConsoleDataSender implements IDataSender {
    private String result;

    @Override
    public void sendResult() {
        System.out.println("Ответ: " + result);
    }

    @Override
    public void setResult(String toString) {
        result = toString;
    }
}