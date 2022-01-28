package sit.int204.lab01;

import sit.int204.lab01.beans.Car;
import sit.int204.lab01.beans.Engine;
import sit.int204.lab01.beans.GasolineEngine;

public class Test {
    public static void main(String[] args) {
        Engine ge = new GasolineEngine(3000);
        Car carA = new Car("ZB25478-23958D", "Toyota", ge);
        carA.start();
        System.out.println(carA);
    }
}
