package baseball.util;

import static baseball.constants.MessageConstants.*;

public class MessageUtil {
    public void printStartMsg() {
        System.out.println(START_GAME_MSG);
    }

    public void printInputMsg() {
        System.out.print(INPUT_MSG);
    }

    public void printResultMsg(int strike, int ball) {
        StringBuilder result = new StringBuilder();

        if (ball == 0 && strike == 0) {
            System.out.println(NOTHING);
            return;
        }
        if (ball != 0) {
            result.append(ball).append(BALL);
        }
        if (strike != 0) {
            result.append(strike).append(STRIKE);
        }

        System.out.println(result);
    }

    public void printSuccessMsg() {
        System.out.println(SUCCESS_MSG);
        System.out.println(GAME_LOOP_MSG);
    }
}
