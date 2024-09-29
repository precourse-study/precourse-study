package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.dto.ResultResponseDto;
import racingcar.service.InputService;
import racingcar.service.RacingService;
import racingcar.view.OutputView;

public class RacingCarController {
    private final OutputView outputView;
    private final RacingService racingService;
    private final InputService inputService;

    public RacingCarController(OutputView outputView, RacingService racingService, InputService inputService) {
        this.outputView = outputView;
        this.racingService = racingService;
        this.inputService = inputService;
    }

    public void playGame() {
        outputView.printStartMsg();
        List<Car> car = inputService.requestCarList();

        outputView.printTrialInputMsg();
        int trialNum = inputService.requestTrial();

        outputView.printResultMsg();
        runRacingTrials(car, trialNum);

        List<String> finalWinner = racingService.findWinners(car);
        outputView.printWinner(finalWinner);
    }

    private void runRacingTrials(List<Car> car, int trialNum) {
        for (int i = 0; i < trialNum; i++) {
            List<ResultResponseDto> result = racingService.playRacingCar(car);
            outputView.printRacing(result);
        }
    }


}
