package baseball.domain;

import java.util.List;

public class Computer {

	private final List<Integer> numbers;

	private Computer(final List<Integer> numbers) {
		this.numbers = numbers;
	}

	public static Computer of(final List<Integer> numbers) {
		return new Computer(numbers);
	}

	public boolean isContainsNumber(final int number) {
		return numbers.contains(number);
	}

	public boolean isMatchNumber(final int number, final int idx) {
		return numbers.get(idx) == number;
	}

}
