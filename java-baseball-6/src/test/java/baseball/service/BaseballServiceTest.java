package baseball.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.dto.BaseballResult;
import baseball.util.generator.NumbersGenerator;
import baseball.util.validator.BaseballNumbersValidator;
import baseball.util.validator.NumbersValidator;

class BaseballServiceTest {

	private NumbersValidator numbersValidator;
	private NumbersGenerator numbersGenerator;
	private BaseballService baseballService;

	@BeforeEach
	void setUp() {
		numbersValidator = BaseballNumbersValidator.getInstance();
		numbersGenerator = new MockNumbersGenerator();
		baseballService = BaseballService.of(numbersValidator, numbersGenerator);
	}

	@Test
	@DisplayName("볼 스트라이크 테스트")
	void 볼_스트라이크_테스트() throws Exception {
	    //given
		final List<Integer> userNumbers = List.of(1, 2, 3);
		final User user = baseballService.generateUser(userNumbers);
		final Computer computer = baseballService.generateComputer();
		final BaseballResult baseballResult = baseballService.getBaseballResult(user, computer);

		//when
		final int ball = baseballResult.ball();
		final int strike = baseballResult.strike();

		//then
		assertAll(
			() -> assertThat(ball).isEqualTo(2),
			() -> assertThat(strike).isEqualTo(1)
		);

	}

	@Test
	@DisplayName("게임 종료 테스트")
	void 게임_종료_테스트() throws Exception {
	    //given
		final List<Integer> userNumbers = List.of(1, 3, 2);
		final User user = baseballService.generateUser(userNumbers);
		final Computer computer = baseballService.generateComputer();
		//when
		final BaseballResult baseballResult = baseballService.getBaseballResult(user, computer);
		final int ball = baseballResult.ball();
		final int strike = baseballResult.strike();
		final boolean isEnd = baseballService.isEnd();
		//then
		assertAll(
			() -> assertThat(ball).isZero(),
			() -> assertThat(strike).isEqualTo(3),
			() -> assertThat(isEnd).isTrue()
		);

	}



	private static class MockNumbersGenerator implements NumbersGenerator {

		@Override
		public List<Integer> generate() {
			return List.of(1,3,2);
		}
	}

}