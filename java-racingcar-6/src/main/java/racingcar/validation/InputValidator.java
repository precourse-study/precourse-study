package racingcar.validation;

import static racingcar.constant.NumberConst.*;

import racingcar.constant.ErrorMessageConst;

public class InputValidator {
    public void validate(String input) {
        if(!isValidLength(input)) {
            throw new IllegalArgumentException(ErrorMessageConst.NAME_LENGTH_EXCEPTION_MSG);
        }
    }

    private boolean isValidLength(String name) {
        return name.length() <= NAME_LENGTH;
    }
}
