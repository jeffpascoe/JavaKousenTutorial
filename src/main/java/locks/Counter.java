package locks;

public class Counter {
    private int count;

    public void increment() {
        count++;
    }

    public int getCount() {
        return this.count;
    }
}
