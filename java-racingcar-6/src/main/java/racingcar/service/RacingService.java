package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.dto.ResultResponseDto;

public class RacingService {
    private final MoveRule moveRule;

    public RacingService(MoveRule moveRule) {
        this.moveRule = moveRule;
    }

    public List<ResultResponseDto> playRacingCar(List<Car> carList) {
        List<ResultResponseDto> results = new ArrayList<>();

        for (Car car : carList) {
            car.move(moveRule.tryMove());
        }
        addResult(carList, results);

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

    private void addResult(List<Car> carList, List<ResultResponseDto> results) {
        for (Car car : carList) {
            results.add(ResultResponseDto.of(car.getName(), car.getPositionDisplay()));
        }
    }

}
