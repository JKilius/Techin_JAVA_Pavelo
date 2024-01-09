public class Gauge {
    private int value;

    public Gauge() {
    }

    public void increase() {
        if (value < 5) {
            value++;
        }
    }

    public void decrease() {
        if (value > 0) {
            value--;
        }
    }

    public int value() {
        return value;
    }

    public boolean full() {
        return value == 5;
    }
}
