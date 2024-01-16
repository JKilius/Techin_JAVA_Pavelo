public class TripleTacoBox implements TacoBox {
    private int tacos;

    public TripleTacoBox() {
        tacos = 3;
    }

    @Override
    public int tacosRemaining() {
        return tacos;
    }

    public void setTacos(int tacos) {
        this.tacos = tacos;
    }

    @Override
    public void eat() {
        if (tacos>0)tacos--;
    }
}
