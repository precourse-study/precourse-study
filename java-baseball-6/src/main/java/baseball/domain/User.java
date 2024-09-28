package baseball.domain;

import java.util.List;

import baseball.util.validator.NumbersValidator;

public class User {

	private final List<Integer> numbers;

	private User(final List<Integer> numbers) {
		this.numbers = numbers;
	}

	public static User of(final NumbersValidator numbersValidator, final List<Integer> numbers) {
		numbersValidator.validateSize(numbers);
		numbersValidator.validateRange(numbers);
		numbersValidator.validateDuplicate(numbers);
		return new User(numbers);
	}

	public int getNumber(final int index) {
		return numbers.get(index);
	}

}
