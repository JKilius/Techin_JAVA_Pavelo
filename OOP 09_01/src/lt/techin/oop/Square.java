package lt.techin.oop;

public class Square extends Rectangle {
    public Square() {
    }

    public Square(double side) {
        super(side,side);
//        super.setWidth(side);
//        super.setLength(side);
    }

    public Square(double side, String color, boolean filled) {
        super(side,side,color,filled);
//        super.setWidth(side);
//        super.setLength(side);
//        super.setColor(color);
//        super.setFilled(filled);
    }

    public double getSide() {
        return super.getLength();
    }

    public void setWidth(double side) {
        super.setWidth(side);
    }

    public void setLength(double side) {
        super.setLength(side);
    }

    public String toString() {
        return STR."A Square with side=\{getWidth()}, which is a subclass of \{super.toString()}";
    }
}

