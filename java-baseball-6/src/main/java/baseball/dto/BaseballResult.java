package baseball.dto;

public record BaseballResult(
	int ball,
	int strike
) {

	public static BaseballResult of(int ball, int strike) {
		return new BaseballResult(ball, strike);
	}
}
