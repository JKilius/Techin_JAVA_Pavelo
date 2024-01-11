public class Counter {
    int value;

    public Counter() {
        value=0;
    }

    public Counter(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
    public void increase(){
        value++;
    }
    public void decrease(){
        value--;
    }
    public void increase(int increaseBy){
        if (increaseBy>0){
            value+=increaseBy;
        }
    }
    public void decrease(int decreaseBy){
        if (decreaseBy>0) {
            value -= decreaseBy;
        }
    }
}
