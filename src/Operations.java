import java.math.BigDecimal;
import java.util.ArrayList;

enum Operations {
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

    public BigDecimal getCalculationResult() {
        BigDecimal result = null;

        switch (this) {
            case ADDITION:
                result = numbers.stream().reduce(BigDecimal.ZERO, (BigDecimal::add));
                break;
            case TWO_DIVISION_THIRD_ADDITION:
                result = getTwoDivisionThirdAddition();
                break;
            case MULTIPLICATION:
                result = numbers.stream().reduce(BigDecimal.ONE, (BigDecimal::multiply));
                break;
        }

        return result;
    }

    private BigDecimal getTwoDivisionThirdAddition() {
        BigDecimal result = BigDecimal.ONE;

        for (int i = 0; i < numbers.size() - 1; i++) {
            result = result.multiply(numbers.get(i));
        }

        result = result.add(numbers.get(2));

        return result;
    }
}