package sit.int204.lab01.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Circle implements GeometricShape {
    private double radius = 1.0;

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle: (" + radius + ") -> " + getArea();
    }
}
