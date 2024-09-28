package baseball;

import baseball.config.AppConfig;
import baseball.controller.BaseballController;

public class Application {
    public static void main(String[] args) {

        final AppConfig appConfig = new AppConfig();
        final BaseballController baseballController = appConfig.baseballController();
        baseballController.run();
    }
}
