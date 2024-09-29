package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.dto.ResultResponseDto;

public class RacingService {

    public static final int MIN_NUM = 0;
    public static final int MAX_NUM = 9;
    public static final int BASE_NUM = 4;

    public List<ResultResponseDto> playRacingCar(List<Car> carList) {
        List<ResultResponseDto> results = new ArrayList<>();

        for (Car car : carList) {
            int randomValue = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            if (randomValue >= BASE_NUM) {
                car.move();
            }
        }

        for (Car car : carList) {
            results.add(ResultResponseDto.of(car.getName(), car.getPositionDisplay()));
        }

        return results;
    }

    public List<String> findWinners(List<Car> carList) {
        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

}
