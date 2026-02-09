interface Shape{
    double calculateArea();
}
    class Circle implements Shape{
    double radius;

    Circle(double radius) {
        this.radius =radius;
    }
    @Override
    public double calculateArea(){
        return Math.PI * radius* radius;
    }
}
class Square implements Shape{
    double side;

    Square(double side) {
        this.side =side;
    }
    @Override
    public double calculateArea(){
        return side*side;
    }

}
public class InterfaceShapeArea{
    public static void main(String[] args) {
        Shape circle =new Circle(2.9);
        Shape square =new Square(3.5);
        System.out.println("Area of Circle :"+ circle.calculateArea());
        System.out.println("Area of Square :"+ square.calculateArea());
        
    }
}