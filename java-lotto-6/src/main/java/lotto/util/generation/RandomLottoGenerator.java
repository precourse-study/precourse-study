package lotto.util.generation;

import static lotto.constants.NumberConst.NUMBER;
import static lotto.constants.NumberConst.RANGE_MAX;
import static lotto.constants.NumberConst.RANGE_MIN;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoGenerator implements LottoGenerator {

    private RandomLottoGenerator() {
    }

    private static class BillPughSingleton {
        private static final RandomLottoGenerator INSTANCE = new RandomLottoGenerator();
    }

    public static RandomLottoGenerator getInstance() {
        return BillPughSingleton.INSTANCE;
    }

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(RANGE_MIN, RANGE_MAX, NUMBER);
    }
}
