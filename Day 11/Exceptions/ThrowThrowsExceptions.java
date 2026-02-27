import java.io.IOException;

public class ThrowThrowsExceptions{
    static void checkAge(int age) throws IOException{
        if (age<18){
            throw new IOException("Age must be 18 or above");
        }
        System.out.println("Welcome!");

    }
    public static void main(String []args){
        try{
            checkAge(17);
        }catch(IOException e){
            System.out.println("Caught:" +e.getMessage());
        }
    }
}