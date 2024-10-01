package lotto.domain;

import static lotto.constants.ErrorType.*;
import static lotto.constants.NumberConst.*;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER) {
            throw new IllegalArgumentException(INSUFFICIENT_OR_EXCESSIVE_NUMBERS.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
