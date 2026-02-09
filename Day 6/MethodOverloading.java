class Calculator{
    int add(int a, int b){
    return a+b;
    }
    double add (double a,double b){
        return a+b;   
    }
    int add(int a,int b,int c){
        return a+b+c;
    }
}
public class MethodOverloading{
    public static void main(String[] args) {
        Calculator cr =new Calculator();
        System.out.println("Addition of two integers : " + cr.add(22, 54));
        System.out.println("Addition of two double : " + cr.add(19.3,28.5));
        System.out.println("Addition of three integers : " + cr.add(11,22,52));

    }
}
