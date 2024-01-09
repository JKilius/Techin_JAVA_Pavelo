package lt.techin.oop0;

public class Circle {
    private double radius;
    private String color;

    public Circle () {
        radius=1.0;
        color="red";
    }

    public Circle (double radius) {
        this.radius = radius;
        color = "red";
    }

    public Circle (double radius, String color) {
        this.radius = radius;
        this.color=color;
    }

    public String getColor () {
        return color;
    }
    public double getRadius() {
        return radius;
    }
    public double getArea() {
        return radius*radius*Math.PI;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void setRadius (double radius) {
        this.radius = radius;
    }
    public String toString () {
        return "Circle [radius="+radius + " color="+color +"]";
    }
}
