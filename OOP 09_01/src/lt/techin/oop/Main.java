package lt.techin.oop;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
//        Shape shape= new Shape("Magenta",true);
//        System.out.println(shape);
        Shape circle = new Circle(5.0, "Pilka", false);
        Shape rectangle = new Rectangle(4, 5, "Blue", true);
        Shape square = new Square(4, "Yellow", true);
//        System.out.println(circle);
//        System.out.println(rectangle);
//        System.out.println(square);
        ArrayList<Shape> shapes = new ArrayList<>();
        Collections.addAll(shapes, circle, rectangle, square);
//        shapes.add(circle);
//        shapes.add(rectangle);
//        shapes.add(square);
        double sumArea = 0.0;
        double largestPerimeter = 0.0;
        String name = "";
        for (Shape shape : shapes) {
            if (largestPerimeter < shape.getPerimeter()) {
                largestPerimeter = shape.getPerimeter();
                if (shape instanceof Circle) {
                    name = "circle";
                } else if (shape instanceof Rectangle) {
                    name = "rectangle";
                } else {
                    name = "square";
                }
            }
            sumArea += shape.getArea();
            System.out.println(shape);
            System.out.println(STR."shape= \{shape.getArea()}");
            System.out.println(STR."perimeter= \{shape.getPerimeter()}");
        }
        System.out.println(STR."Sum of area of all shapes: \{sumArea}");
        System.out.println(STR."Shape with largest perimeter: \{name}");
        if (square instanceof Square) {
            Square sq = (Square) square;
            System.out.println("Side of a square: " + sq.getSide());
        }
        
    }
}
