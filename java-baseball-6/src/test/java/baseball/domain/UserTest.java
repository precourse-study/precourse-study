package baseball.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.util.validator.BaseballNumbersValidator;
import baseball.util.validator.NumbersValidator;

class UserTest {

	private NumbersValidator numbersValidator;

	@BeforeEach
	void setUp() throws Exception {
		numbersValidator = BaseballNumbersValidator.getInstance();
	}

	@DisplayName("잘못된 숫자 조합 테스트")
	@MethodSource("numbersSource")
	@ParameterizedTest
	void 숫자_조합_테스트(List<Integer> numbers) throws Exception {
	    //given
	    //when
	    //then
		assertThatThrownBy(() -> User.of(numbersValidator, numbers)).isInstanceOf(IllegalArgumentException.class);

	}

	static Stream<List<Integer>> numbersSource() {
		return Stream.of(
			List.of(1,2,10),
			List.of(1,2),
			List.of(1,2,3,4)
		);
	}
}