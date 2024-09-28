package baseball.view;

import static baseball.constant.Rule.*;

import baseball.constant.Rule;

public class OutputView {

	private static final String INTRO = "숫자 야구 게임을 시작합니다.";
	private static final String ASK_NUMBERS = "숫자를 입력해주세요 : ";
	private static final String BALL = "%d볼";
	private static final String STRIKE = "%d스트라이크";
	private static final String BALL_AND_STRIKE = "%d볼 %d스트라이크";
	private static final String NOTHING = "낫싱";
	private static final String END = String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", NUMBERS_SIZE);
	private static final String ASK_RETRY = String.format("게임 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.", RETRY, STOP);

	public void printIntro() {
		System.out.println(INTRO);
	}

	public void printAskNumbers() {
		System.out.print(ASK_NUMBERS);
	}

	public void printBall(final int ball) {
		final String message = String.format(BALL, ball);
		System.out.println(message);
	}

	public void printStrike(final int strike) {
		final String message = String.format(STRIKE, strike);
		System.out.println(message);
	}

	public void printBallAndStrike(final int ball, final int strike) {
		final String message = String.format(BALL_AND_STRIKE, ball, strike);
		System.out.println(message);
	}

	public void printNothing() {
		System.out.println(NOTHING);
	}

	public void printEnd() {
		System.out.println(END);
	}

	public void printAskRetry() {
		System.out.println(ASK_RETRY);
	}
}
