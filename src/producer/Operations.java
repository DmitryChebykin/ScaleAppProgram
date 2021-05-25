package producer;

import java.math.BigDecimal;
import java.util.ArrayList;

public enum Operations {
    ADDITION("add"),
    TWO_DIVISION_THIRD_ADDITION("sup"),
    MULTIPLICATION("mul");

    private final String operationName;
    private ArrayList<BigDecimal> numbers = null;

    Operations(String operationName) {
        this.operationName = operationName;
    }

    public static Operations getByName(String name) {
        for (Operations o : Operations.values()) {
            if (o.operationName.equals(name)) {
                return o;
            }
        }

        return null;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setNumbers(ArrayList<BigDecimal> numbers) {
        this.numbers = numbers;
    }

    public BigDecimal getResult() {
        BigDecimal result = null;

        switch (this) {
            case ADDITION:
                result = numbers.stream().reduce(BigDecimal.ZERO, (BigDecimal::add));
                break;
            case TWO_DIVISION_THIRD_ADDITION:
                result = numbers.stream().limit(2).reduce(BigDecimal.ONE, (BigDecimal::multiply)).add(numbers.get(2));
                break;
            case MULTIPLICATION:
                result = numbers.stream().reduce(BigDecimal.ONE, (BigDecimal::multiply));
                break;
        }

        return result;
    }
}