package baseball.constant;

import static baseball.error.ErrorType.*;

import java.util.Arrays;
import java.util.Objects;

import baseball.error.exception.InvalidInputException;

public enum Command {
	RETRY(Rule.RETRY),
	STOP(Rule.STOP),;

	private final String rule;

	Command(final String rule) {
		this.rule = rule;
	}

	public static Command findByInput (final String input) {
		return Arrays.stream(Command.values())
			.filter(command -> Objects.equals(command.getRule(), input))
			.findAny()
			.orElseThrow(() -> new InvalidInputException(INVALID_COMMAND));
	}

	public String getRule() {
		return rule;
	}
}
