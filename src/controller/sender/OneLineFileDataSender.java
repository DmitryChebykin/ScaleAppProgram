package controller.sender;

import java.io.*;

public class OneLineFileDataSender extends DataSender {
    private String result;
    private String filePath;

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void sendResult() {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)))) {
            writer.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setResult(String toString) {
        this.result = toString;
    }
}