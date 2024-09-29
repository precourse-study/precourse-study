package racingcar.view;

import static racingcar.constant.MessageConst.*;

import java.util.List;
import racingcar.dto.ResultResponseDto;

public class OutputView {
    public void printStartMsg() {
        System.out.println(START_MSG);
    }

    public void printTrialInputMsg() {
        System.out.println(TRIAL_NUM_MSG);
    }

    public void printResultMsg() {
        System.out.println(RESULT_MSG);
    }

    public void printRacing(List<ResultResponseDto> responseDtos) {
        responseDtos.forEach(dto -> System.out.println(dto.getName() + " : " + dto.getPositionDisplay()));
        System.out.println();
    }

    public void printWinner(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.println(WINNER_MSG + winnerNames);
    }

}
