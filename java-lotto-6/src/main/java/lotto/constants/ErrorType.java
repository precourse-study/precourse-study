package lotto.constants;

import static lotto.constants.NumberConst.NUMBER;
import static lotto.constants.NumberConst.PRICE;
import static lotto.constants.NumberConst.RANGE_MAX;
import static lotto.constants.NumberConst.RANGE_MIN;

public enum ErrorType {
    INVALID_PURCHASE_PRICE(PRICE + "원 단위로 입력해주세요."),
    INVALID_BONUS_NUM("당첨 번호에 없는 보너스 번호를 입력해주세요."),
    INVALID_INPUT_FORMAT("숫자를 입력해주세요."),
    DUPLICATION_NUM("당첨 숫자는 중복될 수 없습니다. 다시 입력해주세요."),
    INSUFFICIENT_OR_EXCESSIVE_NUMBERS("당첨 숫자는 " + NUMBER + "개를 입력해주세요."),
    OUT_OF_RANGE_NUMBER("당첨 숫자는 " + RANGE_MIN + "~" + RANGE_MAX + " 범위로 입력해주세요");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorType(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
    }
