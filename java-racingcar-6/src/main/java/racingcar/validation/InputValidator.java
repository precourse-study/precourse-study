package racingcar.validation;

import static racingcar.constant.ErrorMessageConst.*;
import static racingcar.constant.NumberConst.*;

import java.util.List;
import racingcar.domain.Car;

public class InputValidator {
    public void validateName(String input) {
        if(input.isEmpty()) {
            throw new IllegalArgumentException(NAME_NULL_POINTER_EXCEPTION_MSG);
        }
        if(!isValidLength(input)) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MSG);
        }
    }

    public void validateDuplicate(List<String> strings, List<Car> cars) {
        if(strings.size() != cars.size()) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MSG);
        }
    }

    public int validateTrialNum(String trial) {
        if(trial.isEmpty()) {
            throw new IllegalArgumentException(NUM_NULL_POINTER_EXCEPTION_MSG);
        }
        try {
            return Integer.parseInt(trial);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_FORMAT_EXCEPTION_MSG);
        }
    }

    private boolean isValidLength(String name) {
        return name.length() <= NAME_MAX_LENGTH && name.length() >= NAME_MIN_LENGTH;
    }
}
