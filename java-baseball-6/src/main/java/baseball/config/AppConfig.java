package baseball.config;

import baseball.controller.BaseballController;
import baseball.service.BaseballService;
import baseball.util.convertor.BaseballInputConvertor;
import baseball.util.convertor.InputConvertor;
import baseball.util.generator.NumbersGenerator;
import baseball.util.generator.RandomNumbersGenerator;
import baseball.util.validator.BaseballInputValidator;
import baseball.util.validator.BaseballNumbersValidator;
import baseball.util.validator.InputValidator;
import baseball.util.validator.NumbersValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class AppConfig {

	public InputView inputView() {
		return new InputView();
	}

	public OutputView outputView() {
		return new OutputView();
	}

	public InputValidator inputValidator() {
		return BaseballInputValidator.getInstance();
	}

	public NumbersValidator numbersValidator() {
		return BaseballNumbersValidator.getInstance();
	}

	public InputConvertor inputConvertor() {
		return BaseballInputConvertor.getInstance();
	}

	public NumbersGenerator numbersGenerator() {
		return RandomNumbersGenerator.getInstance();
	}

	public BaseballService baseballService() {
		return BaseballService.of(numbersValidator(), numbersGenerator());
	}

	public BaseballController baseballController() {
		return BaseballController.of(
			inputValidator(),
			inputConvertor(),
			inputView(),
			outputView(),
			baseballService()
		);
	}



}
