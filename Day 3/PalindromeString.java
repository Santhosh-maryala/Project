
import java.util.Scanner;


public class PalindromeString
{
    public static void main(String[]args)
    {
       /* Scanner sc =new Scanner(System.in);
        System.out.println("Enter your string:");
        String str = sc.next();
        String org_str =str;
        String rev="";
        int len =str.length();

        for(int i=len-1;i>=0;i--)
        {
            rev=rev+str.charAt(i);
        }

        if (org_str.equals(rev))
        {
            System.out.println(org_str+" is Palindrome String");
        }
        else
        {
            System.out.println(org_str+" is Not Palindrome String");
        } */

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String:");
        
        String str =sc.nextLine();

        StringBuilder sbl =new StringBuilder(str);
        sbl.reverse();

        if(str.equals(sbl.toString()))
        {
            System.out.println("Palindrome");
        }
        else{
            System.out.println("Not Palindrome");
        }
       
    }

}
