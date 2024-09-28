package baseball.constants;

import static baseball.constants.NumberConstants.EXIT_NUM;
import static baseball.constants.NumberConstants.FIRST_RANGE;
import static baseball.constants.NumberConstants.INPUT_LENGTH;
import static baseball.constants.NumberConstants.LAST_RANGE;
import static baseball.constants.NumberConstants.RESTART_NUM;

public class MessageConstants {
    private MessageConstants() {}

    public static final String START_GAME_MSG = "숫자 야구 게임을 시작합니다.";

    public static final String INPUT_MSG = "숫자를 입력해주세요 : ";

    public static final String BALL = "볼 ";

    public static final String STRIKE = "스트라이크 ";

    public static final String NOTHING = "낫싱";

    public static final String SUCCESS_MSG = INPUT_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static final String GAME_LOOP_MSG = "게임을 새로 시작하려면 " + RESTART_NUM +
            ", 종료하려면 " + EXIT_NUM + "를 입력하세요.";

    public static final String INPUT_LENGTH_EXCEPTION_MSG = INPUT_LENGTH + "글자를 입력해 주세요.";

    public static final String INPUT_RANGE_EXCEPTION_MSG = FIRST_RANGE + "~" +
            LAST_RANGE + " 사이의 값을 입력해 주세요.";

    public static final String INPUT_DUPLICATE_EXCEPTION_MSG = "중복된 숫자는 입력할 수 없습니다.";

    public static final String GAME_CONTROL_EXCEPTION_MSG = RESTART_NUM + "(재시작) 혹은 " +
            EXIT_NUM + "(종료)를 입력해 주세요.";

    public static final String INPUT_FORMAT_EXCEPTION_MSG = "숫자를 입력해주세요";
}
