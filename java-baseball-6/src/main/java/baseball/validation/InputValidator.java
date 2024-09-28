package baseball.validation;

import static baseball.constants.ErrorMessageConstants.*;

import java.util.HashSet;

public class InputValidator {
    String[] input;

    public void validate(String[] input) {
        this.input = input;

        if (isLengthValid()) {
            throw new IllegalArgumentException(INPUT_LENGTH_EXCEPTION_MSG);
        }

        for (String s : input) {
            try {
                if (!isRangeValid(Integer.parseInt(s))) {
                    throw new IllegalArgumentException(INPUT_RANGE_EXCEPTION_MSG);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(INPUT_FORMAT_EXCEPTION_MSG);
            }
        }

        if (hasDuplicates()) {
            throw new IllegalArgumentException(INPUT_DUPLICATE_EXCEPTION_MSG);
        }
    }

    private boolean isLengthValid() {
        return input.length != 3;
    }

    private boolean isRangeValid(int num) {
        return num >= 1 && num <= 9;
    }

    private boolean hasDuplicates() {
        HashSet<String> set = new HashSet<>();

        for (String num : input) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}