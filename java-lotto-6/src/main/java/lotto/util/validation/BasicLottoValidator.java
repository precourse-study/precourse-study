package lotto.util.validation;

import static lotto.constants.ErrorType.*;
import static lotto.constants.NumberConst.RANGE_MAX;
import static lotto.constants.NumberConst.RANGE_MIN;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BasicLottoValidator implements LottoValidator {

    private BasicLottoValidator() {
    }

    private static class BillPughSingleton {
        private static final BasicLottoValidator INSTANCE = new BasicLottoValidator();
    }

    public static BasicLottoValidator getInstance() {
        return BasicLottoValidator.BillPughSingleton.INSTANCE;
    }

    @Override
    public void validateFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT.getMessage());
        }
    }

    @Override
    public void validateLottoNum(int num) {
        if(num < RANGE_MIN || num > RANGE_MAX) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER.getMessage());
        }
    }

    @Override
    public void validateNoDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATION_NUM.getMessage());
        }
    }

    @Override
    public void validateBonusNum(List<Integer> winningNum, int bonus) {
        if(winningNum.contains(bonus)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUM.getMessage());
        }
    }

    @Override
    public void validateWinningNum(List<Integer> winningNum) {
        if (winningNum.size() != 6) {
            throw new IllegalArgumentException(INSUFFICIENT_OR_EXCESSIVE_NUMBERS.getMessage());
        }
    }
}
