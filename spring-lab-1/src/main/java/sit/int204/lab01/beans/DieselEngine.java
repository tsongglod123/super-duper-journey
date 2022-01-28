package sit.int204.lab01.beans;

public class DieselEngine implements Engine {
    private int capacity;

    public DieselEngine() {
    }

    public DieselEngine(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void turnOn() {
        System.out.println("Turn on - Diesel Engine");
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public void turnOff() {
        System.out.println("Turn off - Diesel Engine");
    }
}
