package lotto.util.validation;

import java.util.List;

public interface LottoValidator {
    void validateFormat(String input);
    void validateLottoNum(int num);
    void validateNoDuplicate(List<Integer> numbers);
    void validateBonusNum(List<Integer> winningNum, int bonus);
    void validateLottoSize(List<Integer> lotto);
}
