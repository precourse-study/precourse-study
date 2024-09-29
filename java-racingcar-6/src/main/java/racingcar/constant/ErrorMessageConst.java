package racingcar.constant;

import static racingcar.constant.NumberConst.*;

public class ErrorMessageConst {
    private ErrorMessageConst() {
    }

    public static final String NAME_LENGTH_EXCEPTION_MSG =
            "이름은 " + NAME_MIN_LENGTH + "자 이상" + NAME_MAX_LENGTH + "자 이하만 가능합니다.";
    public static final String INPUT_FORMAT_EXCEPTION_MSG = "숫자를 입력해주세요.";
    public static final String DUPLICATE_EXCEPTION_MSG = "자동차 이름은 중복될 수 없습니다.";
    public static final String NAME_NULL_POINTER_EXCEPTION_MSG = "자동차 이름은 비어있을 수 없습니다.";
    public static final String NUM_NULL_POINTER_EXCEPTION_MSG = "시도 횟수는 비어있을 수 없습니다.";

}
