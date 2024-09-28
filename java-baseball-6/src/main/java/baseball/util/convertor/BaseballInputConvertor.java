package baseball.util.convertor;

import java.util.Arrays;
import java.util.List;

public class BaseballInputConvertor implements InputConvertor {

	private static final String DELIMITER = "";

	private BaseballInputConvertor() {

	}

	public static BaseballInputConvertor getInstance() {
		return BillPughSingleton.INSTANCE;
	}

	@Override
	public List<Integer> convertToNumbers(final String input) {
		final String[] split = input.split(DELIMITER);
		return Arrays.stream(split)
			.map(Integer::parseInt)
			.toList();
	}

	private static class BillPughSingleton {
		private static final BaseballInputConvertor INSTANCE = new BaseballInputConvertor();
	}
}
