
import java.util.Scanner;

public class CSVToFormatted{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        System.out.println("Enter CSV data(ID,Name,Salary):");
        String input =sc.nextLine();
        int firstComma =input.indexOf(",");
        int secondComma =input.indexOf(",",firstComma +1);
        if(firstComma!=-1 && secondComma != -1){
            String id = input.substring(0,firstComma);
            String name =input.substring(firstComma+1, secondComma);
            String salary =input.substring(secondComma+1);
            System.out.println("ID : " + id + "Name : " + name + "Salary : " +salary);

        }else{
            System.out.println("Invalid CSV formate");
        }
        sc.close();
    }
}