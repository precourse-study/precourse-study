package racingcar.config;

import racingcar.controller.RacingCarController;
import racingcar.converter.InputConverter;
import racingcar.service.InputService;
import racingcar.service.RacingService;
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
        return new RacingService();
    }

    public InputService inputService() {
        return new InputService(inputConverter(), inputValidator(), inputView());
    }

    public InputConverter inputConverter() {
        return new InputConverter();
    }

    public InputValidator inputValidator() {
        return new InputValidator();
    }

    public RacingCarController racingCarController() {
        return new RacingCarController(outputView(), racingService(), inputService());
    }
}
