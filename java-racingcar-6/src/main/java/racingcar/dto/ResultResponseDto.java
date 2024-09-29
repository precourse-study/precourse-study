package racingcar.dto;

public class ResultResponseDto {
    private final String name;
    private final String positionDisplay;

    private ResultResponseDto(String name, String positionDisplay) {
        this.name = name;
        this.positionDisplay = positionDisplay;
    }

    public String getName() {
        return name;
    }

    public String getPositionDisplay() {
        return positionDisplay;
    }

    public static ResultResponseDto of(String name, String positionDisplay) {
        return new ResultResponseDto(name, positionDisplay);
    }
}
