package util;

import producer.Operations;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommandChecker {
    private static final int MIN_NUMBERS_QUANTITY_FOR_SUP = 3;
    private static final int MIN_NUMBERS_QUANTITY = 2;

    private String command;
    private String parsedOperation;
    private String[] parsedNumbers;

    public CommandChecker(String command) {
        this.command = command;
        parsedOperation = getParsedCommand()[0];
        String[] temp = new String[getParsedCommand().length - 1];
        System.arraycopy(getParsedCommand(), 1, temp, 0, getParsedCommand().length);
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
        parsedOperation = getParsedCommand()[0];
        String[] temp = new String[getParsedCommand().length - 1];
        System.arraycopy(getParsedCommand(), 1, temp, 0, getParsedCommand().length - 1);
        parsedNumbers = temp;
    }

    private String[] getParsedCommand() {
        command = command.trim();
        return command.split("\\s+");
    }

    private boolean isOperationValid() {
        String consoleOperation = getParsedCommand()[0];
        return Stream.of(Operations.values()).anyMatch(x -> x.getOperationName().equals(consoleOperation));
    }

    private boolean isSupNumbersQuantityValid() {
        return parsedNumbers.length >= MIN_NUMBERS_QUANTITY_FOR_SUP;
    }

    private boolean isNumbersValid() {
        if (parsedNumbers.length < MIN_NUMBERS_QUANTITY) {
            return false;
        }

        if (parsedOperation.equals(Operations.TWO_DIVISION_THIRD_ADDITION.getOperationName()) && !isSupNumbersQuantityValid()) {
            return false;
        }

        //TODO redo the check for validity of numbers through regular expressions, not throw try-catch block
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

        return Arrays.stream(parsedNumbers).map(BigDecimal::new).collect(Collectors.toCollection(ArrayList::new));
    }
}