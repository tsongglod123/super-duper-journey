package sit.int204.lab01.beans;

public class Car {
    private String chasisNumber;
    private String brand;
    private Engine engine;

    public Car() {
    }

    public Car(String chasisNumber, String brand, Engine engine) {
        this.chasisNumber = chasisNumber;
        this.brand = brand;
        this.engine = engine;
    }

    public String getChasisNumber() {
        return chasisNumber;
    }

    public String getBrand() {
        return brand;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setChasisNumber(String chasisNumber) {
        this.chasisNumber = chasisNumber;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.turnOn();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("chasisNumber='").append(chasisNumber).append('\'');
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", engine=").append(engine.getCapacity());
        sb.append('}');
        return sb.toString();
    }
}
