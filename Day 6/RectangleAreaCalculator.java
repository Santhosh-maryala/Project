class Rectangle{

    int length;
    int width;

    public Rectangle(int l,int w) {
        length =l;
        width = w;  
    }
    int calculateArea(){
        return length * width;
    }
}
public class RectangleAreaCalculator{
    public static void main(String[] args) {
        Rectangle rgle =new Rectangle(5,2);
        int area = rgle.calculateArea();
        System.out.println("Area of Rectange:" + area);
    }
}