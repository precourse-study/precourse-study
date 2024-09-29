package racingcar.service;

import java.util.List;
import racingcar.converter.InputConverter;
import racingcar.domain.Car;
import racingcar.validation.InputValidator;
import racingcar.view.InputView;

public class InputService {
    private final InputConverter inputConverter;
    private final InputValidator inputValidator;
    private final InputView inputView;

    public InputService(InputConverter inputConverter, InputValidator inputValidator, InputView inputView) {
        this.inputConverter = inputConverter;
        this.inputValidator = inputValidator;
        this.inputView = inputView;
    }

    public List<Car> requestCarList() {
        String input = inputView.readInput();
        List<String> carStrings = inputConverter.convertToStringList(input);
        carStrings.forEach(inputValidator::validateName);
        List<Car> cars = inputConverter.converToCarList(carStrings);
        inputValidator.validateDuplicate(carStrings, cars);
        return cars;
    }

    public int requestTrial() {
        String trial = inputView.readInput();
        return inputValidator.validateTrialNum(trial);
    }
}
