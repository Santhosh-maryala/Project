
import java.util.Scanner;

public class RemoveHTMLTags{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter HTML text:");
        String input =sc.nextLine();

        String result ="";
        boolean insideTag =false;
        for(int i = 0;i<input.length();i++) {
           char ch =input.charAt(i);
           if(ch=='<'){
            insideTag =true;
           } 
           else if(ch=='>'){
            insideTag=false;
           }
           else if(!insideTag){
            result=result+ch;
           }
        }
        System.out.println("Output" +result);
        sc.close();
    }
}