package sit.int204.lab01.beans;

public class GeometricShapeFactory {
    public static GeometricShape getRectangle() {
        return new Rectangle();
    }

    public static GeometricShape getCircle() {
        return new Circle();
    }

    public GeometricShape getGeometricShape(Class<? extends GeometricShape> shapeClass) {
        GeometricShape object = null;
        try {
            object = shapeClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }
}
