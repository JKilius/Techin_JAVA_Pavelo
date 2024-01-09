package lt.techin.oop0;

public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        System.out.println("The circle has radius of " + c1.getRadius() + " and area of " + c1.getArea() + " and color " + c1.getColor());
        Circle c2 = new Circle(2.0);
        System.out.println("The circle has radius of " + c2.getRadius() + " and area of " + c2.getArea() + " and color " + c2.getColor());
        Circle c3 = new Circle(2.0, "Blue");
        System.out.println("The circle has radius of " + c3.getRadius() + " and area of " + c3.getArea() + " and color " + c3.getColor());
        Circle c4 = new Circle();
        c4.setRadius(5.0);
        System.out.println("radius is: " + c4.getRadius());
        c4.setColor("pink");
        System.out.println("color is: " + c4.getColor());
//        System.out.println(c1.toString()+"\n"+c2.toString()+"\n"+c3.toString()+"\n"+c4.toString());
        System.out.println(c1+"\n"+c2+"\n"+c3+"\n"+c4);
        System.out.println("Operator '+' invokes toString() too: "+c2 );
    }
}
