package baseball.error;

import static baseball.constant.Rule.*;

public enum ErrorType {
	DUPLICATE_NUMBERS("숫자 조합은 중복될 수 없습니다."),
	INVALID_NUMBERS_SIZE(String.format("숫자 조합의 사이즈는 %d 이어야 합니다.", NUMBERS_SIZE)),
	INVALID_NUMBERS_RANGE(String.format("숫자는 %d 이상 %d 이하여야 합니다.", NUMBER_MIN, NUMBER_MAX)),
	INVALID_INPUT("입력은 숫자만 가능합니다."),
	INVALID_COMMAND(String.format("%s또는 %s만 입력 가능합니다.", RETRY, STOP));

	private static final String PREFIX = "[ERROR] ";
	private final String message;

	ErrorType(final String message) {
		this.message = PREFIX + message;
	}

	public String getMessage() {
		return message;
	}
}
