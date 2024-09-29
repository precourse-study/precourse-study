package racingcar.domain;

import java.util.Objects;

public class Car {
    private String name;
    private int position;

    private Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public static Car create(String name) {
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position++;
    }

    public String getPositionDisplay() {
        return "-".repeat(position);
    }

}
