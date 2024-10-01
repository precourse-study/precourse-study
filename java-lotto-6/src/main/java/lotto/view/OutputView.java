package lotto.view;

import static lotto.constants.Message.*;

import java.util.List;
import java.util.stream.IntStream;
import lotto.dto.LottoDto;
import lotto.dto.LottoResultDto;

public class OutputView {

    public void printStartMsg() {
        System.out.println(START_PURCHASE_AMOUNT_MSG);
    }

    public void printPurchase(int count) {
        System.out.println(count + PURCHASE_MSG);
    }

    public void printWinningNumMsg() {
        System.out.println(ENTER_WINNING_NUM_MSG);
    }

    public void printBonusNumMsg() {
        System.out.println(ENTER_BONUS_NUM_MSG);
    }

    public void printWinningStatMsg() {
        System.out.println(WINNING_STATISTICS);
    }

    public void printLottoNumList(List<LottoDto> lottoDtoList) {
        lottoDtoList.forEach(this::printLotto);
    }

    private void printLotto(LottoDto dto) {
        System.out.println(dto.lotto());
    }

    public void printWinningDetail(LottoResultDto dto) {
        IntStream.range(0, RANKS.size())
                .forEach(i -> System.out.printf(RANKS.get(i) + "\n", dto.result().get(i)));
    }

    public void printRevenueResult(LottoResultDto dto) {
        System.out.printf(REVENUE_RESULT, dto.revenue());
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

}
