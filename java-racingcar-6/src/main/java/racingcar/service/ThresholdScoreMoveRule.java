package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public final class ThresholdScoreMoveRule implements MoveRule {

    private static final int MIN_MOVE_NUMBER = 4;
    private static final int FORWARD = 1;
    private static final int STOP = 0;
    public static final int MIN_NUM = 0;
    public static final int MAX_NUM = 9;

    @Override
    public int tryMove() {
        int number = generateNum();
        if (number >= MIN_MOVE_NUMBER) {
            return FORWARD;
        }
        return STOP;
    }

    private int generateNum() {
        return Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
    }
}
