package lotto.domain;

import java.util.List;
import lotto.util.validation.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers, LottoValidator lottoValidator) {
        validate(numbers, lottoValidator);
        this.numbers = numbers.stream().sorted().toList();
    }

    private void validate(List<Integer> numbers, LottoValidator lottoValidator) {
        lottoValidator.validateNoDuplicate(numbers);
        lottoValidator.validateLottoSize(numbers);
        numbers.forEach(lottoValidator::validateLottoNum);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
