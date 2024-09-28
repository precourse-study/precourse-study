package baseball.service;

import static baseball.constant.Rule.*;

import java.util.List;

import baseball.constant.Command;
import baseball.domain.Computer;
import baseball.domain.User;
import baseball.dto.BaseballResult;
import baseball.util.generator.NumbersGenerator;
import baseball.util.validator.NumbersValidator;

public class BaseballService {

	private final NumbersValidator numbersValidator;
	private final NumbersGenerator numbersGenerator;
	private int strike;
	private int ball;

	private BaseballService(final NumbersValidator numbersValidator, final NumbersGenerator numbersGenerator) {
		this.numbersValidator = numbersValidator;
		this.numbersGenerator = numbersGenerator;
	}

	public static BaseballService of(final NumbersValidator numbersValidator, final NumbersGenerator numbersGenerator) {
		return new BaseballService(numbersValidator, numbersGenerator);
	}

	public Computer generateComputer() {
		final List<Integer> numbers = numbersGenerator.generate();
		return Computer.of(numbers);
	}

	public User generateUser(final List<Integer> numbers) {
		return User.of(numbersValidator, numbers);
	}

	public BaseballResult getBaseballResult(final User user, final Computer computer) {
		ball = countBall(user, computer);
		strike = countStrike(user, computer);
		return BaseballResult.of(ball, strike);
	}

	public boolean isEnd() {
		return strike == NUMBERS_SIZE;
	}

	private int countBall(final User user, final Computer computer) {
		int ball = 0;
		for (int idx = 0; idx < NUMBERS_SIZE; idx++) {
			final int number = user.getNumber(idx);
			if (computer.isContainsNumber(number) && !computer.isMatchNumber(number, idx)) {
				ball++;
			}
		}
		return ball;
	}

	private int countStrike(final User user, final Computer computer) {
		int strike = 0;
		for (int idx = 0; idx < NUMBERS_SIZE; idx++) {
			final int number = user.getNumber(idx);
			if(computer.isMatchNumber(number, idx)) {
				strike++;
			}
		}
		return strike;
	}


}
