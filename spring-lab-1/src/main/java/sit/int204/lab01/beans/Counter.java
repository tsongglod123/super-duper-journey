package sit.int204.lab01.beans;

public class Counter {
    private static final Counter INSTANCE = new Counter();
    private int count;

    private Counter() {
    }

    public static Counter getInstance() {
        return INSTANCE;
    }

    public void increment() {
        ++count;
    }

    public int getCount() {
        return count;
    }
}
