package baseball.util.validator;

import java.util.List;

public interface NumbersValidator {

	void validateRange(final List<Integer> numbers);
	void validateDuplicate(final List<Integer> numbers);
	void validateSize(final List<Integer> numbers);
}
