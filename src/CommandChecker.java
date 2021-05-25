import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.stream.Stream;

public class CommandChecker {
    private static final int MIN_NUMBERS_QUANTITY_FOR_SUP = 3;
    private static final int MIN_NUMBERS_QUANTITY = 2;

    private String command;
    private String parsedOperation;
    private String[] parsedNumbers;

    public CommandChecker(String command) {
        this.command = command;
        parsedOperation = getParsedOperation()[0];
        String[] temp = new String[getParsedOperation().length - 1];
        System.arraycopy(getParsedOperation(), 1, temp, 0, getParsedOperation().length);
        parsedNumbers = temp;
    }

    public CommandChecker() {
        command = null;
        parsedOperation = null;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
        parsedOperation = getParsedOperation()[0];
        String[] temp = new String[getParsedOperation().length - 1];
        System.arraycopy(getParsedOperation(), 1, temp, 0, getParsedOperation().length - 1);
        parsedNumbers = temp;
    }

    public boolean isCommandRight() {
        return false;
    }

    private String[] getParsedOperation() {
        command.trim();
        return command.split("\\s+");
    }

    private boolean isOperationValid() {
        String consoleOperation = getParsedOperation()[0];
        return Stream.of(Operations.values()).anyMatch(x -> x.getOperationName().equals(consoleOperation));
    }

    private boolean isNumbersQuantityForSuperCalcValid() {
        return parsedNumbers.length >= MIN_NUMBERS_QUANTITY_FOR_SUP;
    }

    private boolean isNumbersValid() {

        if (parsedNumbers.length < MIN_NUMBERS_QUANTITY) {
            return false;
        }

        if (parsedOperation.equals(Operations.TWO_DIVISION_THIRD_ADDITION.getOperationName()) && !isNumbersQuantityForSuperCalcValid()) {
            return false;
        }

        for (int i = 0; i < parsedNumbers.length; i++) {
            try {
                new BigDecimal(parsedNumbers[i]);
            } catch (final Exception e) {

                return false;
            }
        }

        return true;
    }

    public boolean isCommandValid() {
        return isOperationValid() && isNumbersValid();
    }

    public String getOperation() {
        return parsedOperation;
    }

    public ArrayList<BigDecimal> getNumbers() {
        ArrayList<BigDecimal> numbers = new ArrayList<>();

        for (int i = 0; i < parsedNumbers.length; i++) {
            numbers.add(new BigDecimal(parsedNumbers[i]));
        }

        return numbers;
    }
}