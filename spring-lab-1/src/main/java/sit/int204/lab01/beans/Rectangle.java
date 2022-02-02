package sit.int204.lab01.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rectangle implements GeometricShape {
    private double width = 1.0;
    private double height = 1.0;

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle: (" + width + " x " + height +
                ") -> " + getArea();
    }
}
