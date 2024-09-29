package racingcar.util;

import java.util.List;

public interface InputConvertor<T> {

	List<T> covertToList(final String input);
}
