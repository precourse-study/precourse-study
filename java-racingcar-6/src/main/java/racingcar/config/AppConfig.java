package racingcar.config;

import racingcar.controller.RacingCarController;
import racingcar.domain.Car;
import racingcar.util.InputConvertor;
import racingcar.util.ListValidator;
import racingcar.util.NumberGenerator;
import racingcar.util.RacingCarInputConvertor;
import racingcar.util.RacingCarListValidator;
import racingcar.util.RacingCarStringValidator;
import racingcar.util.RandomNumberGenerator;
import racingcar.util.StringValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

	public InputConvertor<String> inputConvertor() {
		return RacingCarInputConvertor.getInstance();
	}

	public ListValidator<Car> listValidator() {
		return RacingCarListValidator.getInstance();
	}

	public NumberGenerator numberGenerator() {
		return RandomNumberGenerator.getInstance();
	}

	public StringValidator stringValidator() {
		return RacingCarStringValidator.getInstance();
	}

	public InputView inputView() {
		return new InputView();
	}

	public OutputView outputView() {
		return new OutputView();
	}

	public RacingCarController racingCarController() {
		return RacingCarController.of(stringValidator(), listValidator(), numberGenerator(), inputConvertor(),
			inputView(), outputView());
	}
}
