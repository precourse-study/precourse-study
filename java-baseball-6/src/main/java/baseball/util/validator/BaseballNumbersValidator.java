package baseball.util.validator;

import static baseball.constant.Rule.*;
import static baseball.error.ErrorType.*;

import java.util.List;
import baseball.error.exception.InvalidNumbersException;

public class BaseballNumbersValidator implements NumbersValidator {

	private BaseballNumbersValidator() {
	}

	public static BaseballNumbersValidator getInstance() {
		return BillPughSingleton.INSTANCE;
	}

	@Override
	public void validateRange(final List<Integer> numbers) {
		if (isInvalidRange(numbers)) {
			throw new InvalidNumbersException(INVALID_NUMBERS_RANGE);
		}

	}

	@Override
	public void validateDuplicate(final List<Integer> numbers) {
		if (isDuplicate(numbers)) {
			throw new InvalidNumbersException(DUPLICATE_NUMBERS);
		}
	}

	@Override
	public void validateSize(final List<Integer> numbers) {
		if (isInvalidSize(numbers)) {
			throw new InvalidNumbersException(INVALID_NUMBERS_SIZE);
		}

	}

	private boolean isInvalidRange(final List<Integer> numbers) {
		return numbers.stream()
			.anyMatch(number -> number < NUMBER_MIN || number > NUMBER_MAX);
	}

	private boolean isInvalidSize(final List<Integer> numbers) {
		return numbers.size() != NUMBERS_SIZE;
	}

	private boolean isDuplicate(final List<Integer> numbers) {
		return numbers.stream()
			.distinct()
			.count() != numbers.size();
	}

	private static class BillPughSingleton {
		private static final BaseballNumbersValidator INSTANCE = new BaseballNumbersValidator();
	}
}
