package lt.techin.oop;

public abstract class  Shape {
    private String color = "red";
    private boolean filled = true;

    public Shape() {
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        String fill = "";
        if (filled) {
            fill = "filled";
        } else {
            fill = "Not filled";
        }
        return STR."A Shape with color of \{color} and \{fill}";
    }
    public abstract double getArea();
    public abstract double getPerimeter();
}

