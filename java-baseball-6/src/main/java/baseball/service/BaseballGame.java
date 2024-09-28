package baseball.service;

import static baseball.constants.MessageConstants.*;
import static baseball.constants.NumberConstants.*;

import baseball.util.ComputerUtil;
import baseball.util.MessageUtil;
import baseball.util.UserUtil;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private List<Integer> computerNum = new ArrayList<>();
    private List<Integer> userNum = new ArrayList<>();
    private ComputerUtil computerUtil = new ComputerUtil();
    private MessageUtil messageUtil = new MessageUtil();
    private UserUtil userUtil = new UserUtil();

    public BaseballGame() {
        messageUtil.printStartMsg();
    }

    public void startGame() {
        while (true) {
            computerNum = computerUtil.generateNums();
            if (!playGameLoop()) {
                break;
            }
        }

    }

    private boolean playGameLoop() {
        while (true) {
            messageUtil.printInputMsg();
            userNum = userUtil.setUserNum();
            if (getResult()) {
                messageUtil.printSuccessMsg();
                return isFinish();
            }
        }
    }

    private boolean isFinish() {
        String s = Console.readLine();
        if (s.equals("1")) {
            return true;
        } else if (s.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException(GAME_CONTROL_EXCEPTION_MSG);
        }
    }

    private boolean getResult() {
        int strike = calculateStrike();
        int ball = calculateBall();

        messageUtil.printResultMsg(strike, ball);

        return isCorrect(strike);
    }

    private int calculateStrike() {
        int strike = 0;

        for (int i = 0; i < INPUT_LENGTH; i++) {
            if (computerNum.get(i).equals(userNum.get(i))) {
                strike++;
            }
        }

        return strike;
    }

    private int calculateBall() {
        int ball = 0;

        for (int i = 0; i < INPUT_LENGTH; i++) {
            if (!computerNum.get(i).equals(userNum.get(i)) && computerNum.contains(userNum.get(i))) {
                ball++;
            }
        }

        return ball;
    }

    private boolean isCorrect(int strike) {
        return strike == MAX_STRIKE;
    }

}
