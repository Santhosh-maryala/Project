class MyException extends Exception{

    MyException(String message) {
        super(message);
    }
}
public class CustomExceptions {
    static void checkNumber (int num) throws MyException{
        if(num<0){
            throw new MyException("Number cannot be negative");
        }
        else{
            System.out.println("Number is:"+num);
        }
    }
    public static void main(String[] args) {
        try {
            checkNumber(-5);
        }
        catch(MyException e){
            System.out.println("Caught Exception:" + e.getMessage());
        }
        try{
            checkNumber(15);
        }catch(MyException e){
            System.out.println("Caught Exeception:"+ e.getMessage());
        }
    }
}
