package racingcar.config;

import racingcar.controller.RacingCarController;
import racingcar.converter.InputConverter;
import racingcar.service.InputService;
import racingcar.service.MoveRule;
import racingcar.service.RacingService;
import racingcar.service.ThresholdScoreMoveRule;
import racingcar.validation.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {
    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public RacingService racingService() {
        return new RacingService(moveRule());
    }

    public InputService inputService() {
        return new InputService(inputConverter(), inputValidator(), inputView());
    }

    public MoveRule moveRule() {
        return new ThresholdScoreMoveRule();
    }

    public InputConverter inputConverter() {
        return InputConverter.getInstance();
    }

    public InputValidator inputValidator() {
        return new InputValidator();
    }

    public RacingCarController racingCarController() {
        return new RacingCarController(outputView(), racingService(), inputService());
    }
}
