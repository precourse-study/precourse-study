package baseball.error.exception;

import baseball.error.AppException;
import baseball.error.ErrorType;

public class InvalidInputException extends AppException {

	public InvalidInputException(final ErrorType errorType) {
		super(errorType);
	}
}
