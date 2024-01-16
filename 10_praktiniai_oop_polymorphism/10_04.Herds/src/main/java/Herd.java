import java.util.ArrayList;
import java.util.List;

public class Herd implements Movable {
    private List<Movable> herd;

    public Herd() {
        herd = new ArrayList<>();
    }

    public void addToHerd(Movable movable){
        herd.add(movable);
    }
    @Override
    public void move(int dx, int dy) {
        for (Movable movable : herd) {
        movable.move(dx,dy);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Movable movable : herd) {
            sb.append(movable.toString());
            sb.append("\n");  // for newline between each Movable object
        }
        return sb.toString();
    }
}
