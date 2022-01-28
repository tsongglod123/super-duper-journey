package sit.int204.lab01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sit.int204.lab01.beans.Car;

public class CarApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Car car = (Car) context.getBean("car");
        car.start();
        System.out.println(car);

        Car carX = (Car) context.getBean("carX");
        carX.start();
        System.out.println(carX);
    }
}
