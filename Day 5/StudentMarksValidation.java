
import java.util.Scanner;

public class StudentMarksValidation{
    public static void main(String[] args) {
    
     Scanner sc =new Scanner(System.in);
        
        System.out.println("Enter number of Students: ");
        int n =sc.nextInt();
        int [] marks =new int[n];

        int pass=0, fail=0;

        for (int i=0;i<n;i++){
            System.out.println("Enter Student Marks " +(i+1)+ ":");
            marks[i]=sc.nextInt();
        }
        for(int mark :marks){
            if(mark<0 || mark>100){
                System.out.println("Invalid Marks:" +mark);
            }
            else if (mark>=40) 
            {
                pass++;
            }
            else
            {
                fail++;
            }
        }
            System.out.println("Pass Studenys:"+ pass);
            System.out.println("Fail Students :" +fail);
            sc.close();
        }
}