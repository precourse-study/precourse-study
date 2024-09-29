package racingcar.validation;

import static racingcar.constant.ErrorMessageConst.*;
import static racingcar.constant.NumberConst.*;

import racingcar.constant.ErrorMessageConst;

public class InputValidator {
    public void validateName(String input) {
        if(!isValidLength(input)) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MSG);
        }
    }

    public int validateTrialNum(String trial) {
        try {
            return Integer.parseInt(trial);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_FORMAT_EXCEPTION_MSG);
        }
    }

    private boolean isValidLength(String name) {
        return name.length() <= NAME_LENGTH;
    }
}
