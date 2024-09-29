package racingcar.converter;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;

public class InputConverter {
    public List<String> convertToStringList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
    }

    public List<Car> converToCarList(List<String> carStrings) {
        return carStrings.stream().map(Car::create).toList();
    }
}
