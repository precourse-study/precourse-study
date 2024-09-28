package baseball.util.generator;

import static baseball.constant.Rule.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumbersGenerator implements NumbersGenerator {

	private RandomNumbersGenerator() {

	}

	public static RandomNumbersGenerator getInstance() {
		return BillPughSingleton.INSTANCE;
	}

	@Override
	public List<Integer> generate() {
		Set<Integer> numbers = new HashSet<>();
		while (numbers.size() < NUMBERS_SIZE) {
			final int number = Randoms.pickNumberInRange(NUMBER_MIN, NUMBER_MAX);
			numbers.add(number);
		}
		return List.copyOf(numbers);
	}

	private static class BillPughSingleton {
		private static final RandomNumbersGenerator INSTANCE = new RandomNumbersGenerator();
	}
}
