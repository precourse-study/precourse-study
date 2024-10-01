package lotto.domain;

import static lotto.constants.ErrorType.*;
import static lotto.constants.NumberConst.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATION_NUM.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
