package baseball.util.validator;

import static baseball.error.ErrorType.*;

import baseball.error.exception.InvalidInputException;

public class BaseballInputValidator implements InputValidator {

	private static final String REGEX = "\\d+";

	private BaseballInputValidator() {}

	public static BaseballInputValidator getInstance() {
		return BillPughSingleton.INSTANCE;
	}

	@Override
	public void validateInputFormat(final String input) {
		if (!input.matches(REGEX)) {
			throw new InvalidInputException(INVALID_INPUT);
		}
	}

	private static class BillPughSingleton {
		private static final BaseballInputValidator INSTANCE = new BaseballInputValidator();
	}
}
