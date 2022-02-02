package sit.int204.lab01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sit.int204.lab01.beans.Car;
import sit.int204.lab01.beans.Counter;
import sit.int204.lab01.beans.GeometricShape;
import sit.int204.lab01.beans.GeometricShapeFactory;

public class CarApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Car carZ = (Car) context.getBean("carZ");
        carZ.start();
        System.out.println(carZ);

        Counter ca = (Counter) context.getBean("counterA");
        System.out.println("ca: " + System.identityHashCode(ca));

        Counter cb = (Counter) context.getBean("counterB");
        System.out.println("cb: " + System.identityHashCode(cb));

        System.out.println(ca.getCount());
        cb.increment();
        cb.increment();
        System.out.println(ca.getCount());

        GeometricShape rectangle = (GeometricShape) context.getBean("rectangle");
        System.out.println(rectangle);
        GeometricShape circle = (GeometricShape) context.getBean("circle");
        System.out.println(circle);
    }
}
