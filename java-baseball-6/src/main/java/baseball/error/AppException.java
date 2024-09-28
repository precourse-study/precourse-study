package baseball.error;

public abstract class AppException extends IllegalArgumentException {

	protected AppException(final ErrorType errorType) {
		super(errorType.getMessage());
	}
}
