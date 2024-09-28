package baseball.domain;

import static baseball.constants.NumberConstants.FIRST_RANGE;
import static baseball.constants.NumberConstants.INPUT_LENGTH;
import static baseball.constants.NumberConstants.LAST_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    public List<Integer> generateNums() {
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < INPUT_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(FIRST_RANGE, LAST_RANGE);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        return computerNum;
    }
}
