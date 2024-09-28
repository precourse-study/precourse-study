package baseball.error.exception;

import baseball.error.AppException;
import baseball.error.ErrorType;

public class InvalidNumbersException extends AppException {

	public InvalidNumbersException(final ErrorType errorType) {
		super(errorType);
	}

}
