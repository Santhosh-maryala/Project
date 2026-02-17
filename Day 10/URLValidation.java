
import java.util.Scanner;

public class URLValidation{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter URL:");
        String url = sc.nextLine();


        if(url.startsWith("http://") || url.startsWith("https://")){
            System.out.println("Valid URL");
        } else{
            System.out.println("Invalid URL");
        }
        sc.close();
    }
}