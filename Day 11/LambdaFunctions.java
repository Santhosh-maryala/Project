
import java.util.ArrayList;

interface  Calculator{
    int operate(int a,int b);
}
public class LambdaFunctions{
    public static void main(String[] args) {
       Calculator add =(a,b) -> a+b;
        Calculator multi =(a,b) -> a*b;
        System.out.println("Addition:" +add.operate(12, 18));
        System.out.println("Multiplication:" + multi.operate(12,18));
    
        //arraylist and foreach 
        ArrayList<String> names =new ArrayList<>();
        names.add("Ram");
        names.add("Hari");
        names.forEach(name -> System.out.println(name));
    }
}