package sit.int204.lab01;

import sit.int204.lab01.beans.Circle;
import sit.int204.lab01.beans.GeometricShape;
import sit.int204.lab01.beans.GeometricShapeFactory;
import sit.int204.lab01.beans.Rectangle;

public class TestGeometricShape {
    public static void main(String[] args) {
        GeometricShapeFactory gf = new GeometricShapeFactory();

        GeometricShape cir = gf.getGeometricShape(Circle.class);
        System.out.println(cir);

        GeometricShape rec = gf.getGeometricShape(Rectangle.class);
        System.out.println(rec);
    }
}
