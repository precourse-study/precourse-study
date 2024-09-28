package baseball.constants;

import static baseball.constants.NumberConstants.EXIT_NUM;
import static baseball.constants.NumberConstants.FIRST_RANGE;
import static baseball.constants.NumberConstants.INPUT_LENGTH;
import static baseball.constants.NumberConstants.LAST_RANGE;
import static baseball.constants.NumberConstants.RESTART_NUM;

public class ErrorMessageConstants {
    private ErrorMessageConstants() {}

    public static final String INPUT_LENGTH_EXCEPTION_MSG = INPUT_LENGTH + "글자를 입력해 주세요.";

    public static final String INPUT_RANGE_EXCEPTION_MSG = FIRST_RANGE + "~" +
            LAST_RANGE + " 사이의 값을 입력해 주세요.";

    public static final String INPUT_DUPLICATE_EXCEPTION_MSG = "중복된 숫자는 입력할 수 없습니다.";

    public static final String GAME_CONTROL_EXCEPTION_MSG = RESTART_NUM + "(재시작) 혹은 " +
            EXIT_NUM + "(종료)를 입력해 주세요.";

    public static final String INPUT_FORMAT_EXCEPTION_MSG = "숫자를 입력해주세요";

}
