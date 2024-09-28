package baseball.controller;

import java.util.List;

import baseball.constant.Command;
import baseball.domain.Computer;
import baseball.domain.User;
import baseball.dto.BaseballResult;
import baseball.service.BaseballService;
import baseball.util.convertor.InputConvertor;
import baseball.util.validator.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

	private final InputValidator inputValidator;
	private final InputConvertor inputConvertor;
	private final InputView inputView;
	private final OutputView outputView;
	private final BaseballService baseballService;

	private BaseballController(final InputValidator inputValidator, final InputConvertor inputConvertor,
		final InputView inputView,
		final OutputView outputView, final BaseballService baseballService) {
		this.inputValidator = inputValidator;
		this.inputConvertor = inputConvertor;
		this.inputView = inputView;
		this.outputView = outputView;
		this.baseballService = baseballService;
	}

	public static BaseballController of(final InputValidator inputValidator, final InputConvertor inputConvertor,
		final InputView inputView, final OutputView outputView, final BaseballService baseballService) {
		return new BaseballController(inputValidator, inputConvertor, inputView, outputView, baseballService);
	}

	public void run() {
		outputView.printIntro();
		do {
			start();
			outputView.printEnd();
		} while (isRetry());
	}

	private void start() {
		final Computer computer = baseballService.generateComputer();
		do {
			final User user = requestUser();
			final BaseballResult baseballResult = baseballService.getBaseballResult(user, computer);
			responseBaseballResult(baseballResult);
		} while (!baseballService.isEnd());
	}

	private void responseBaseballResult(final BaseballResult baseballResult) {
		final int ball = baseballResult.ball();
		final int strike = baseballResult.strike();
		if (ball != 0  &&  strike == 0) {
			outputView.printBall(ball);
		}
		if (ball != 0 && strike != 0) {
			outputView.printBallAndStrike(ball, strike);
		}
		if (ball == 0 && strike != 0) {
			outputView.printStrike(strike);
		}
		if (ball == 0 && strike == 0) {
			outputView.printNothing();
		}
	}

	private User requestUser() {
		outputView.printAskNumbers();
		final String input = inputView.readInput().trim();
		inputValidator.validateInputFormat(input);
		final List<Integer> numbers = inputConvertor.convertToNumbers(input);
		return baseballService.generateUser(numbers);
	}

	private Command requestRetry() {
		outputView.printAskRetry();
		final String input = inputView.readInput().trim();
		inputValidator.validateInputFormat(input);
		return Command.findByInput(input);
	}

	private boolean isRetry() {
		return requestRetry() == Command.RETRY;
	}

}
