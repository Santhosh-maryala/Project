
import java.util.Random;
import java.util.Scanner;

public class OtpGeneration{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        Random rm =new Random();

        int otpNumber=1000 +rm.nextInt(8000);
        String otp =String.valueOf(otpNumber);
        System.out.println("Your Otp is:" +otp);

        System.out.println("Enter the otp:");
        String userInput =sc.nextLine();

        if(otp.equals(userInput)){
            System.out.println("Otp verified Successfully!");
        }
        else{
            System.out.println("Invalid Otp.Please try agaain...");
        }
        sc.close();
    }
}