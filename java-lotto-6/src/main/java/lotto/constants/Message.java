package lotto.constants;

import static lotto.constants.NumberConst.*;

import java.util.Arrays;
import java.util.List;

public class Message {
    public static final String START_PURCHASE_AMOUNT_MSG = "구입금액을 입력해 주세요.";
    public static final String PURCHASE_MSG = "개를 구매했습니다.";
    public static final String ENTER_WINNING_NUM_MSG = "당첨 번호를 입력해 주세요.";
    public static final String ENTER_BONUS_NUM_MSG = "보너스 번호를 입력해 주세요.";
    public static final String WINNING_STATISTICS = "당첨 통계\n---";
    public static final String REVENUE_RESULT = "총 수익률은 %.1f%%입니다.";
    private static final String FIFTH_WINNER = "3개 일치 (" + String.format("%,d", THREE_MATCHES_PRIZE) + "원) - %d개";
    private static final String FOURTH_WINNER = "4개 일치 (" + String.format("%,d", FOUR_MATCHES_PRIZE) + " 원) - %d개";
    private static final String THIRD_WINNER = "5개 일치 (" + String.format("%,d", FIVE_MATCHES_PRIZE) + "원) - %d개";
    private static final String SECOND_WINNER =
            "5개 일치, 보너스 볼 일치 (" + String.format("%,d", FIVE_BONUS_MATCHES_PRIZE) + "원) - %d개";
    private static final String FIRST_WINNER = "6개 일치 (" + String.format("%,d", SIX_MATCHES_PRIZE) + "원) - %d개";

    public static final List<String> RANKS = Arrays.asList(
            FIFTH_WINNER,
            FOURTH_WINNER,
            THIRD_WINNER,
            SECOND_WINNER,
            FIRST_WINNER
    );

    private Message() {
    }
}
