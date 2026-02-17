
import java.util.Scanner;

public class InvoiceGenerator{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        StringBuilder invoice =new StringBuilder();

        invoice.append("====Store====");
        invoice.append("Customer Name: ");
        System.out.println("Enter Customer Name: ");

        String customerName =sc.nextLine();
        invoice.append(customerName).append("\n");
        invoice.append(String.format("%-15s %-10s %-10s", "Item","Qty","Price","Total"));
    
    String[] items={"Books","Chair","Pen"};
    int[] quantities ={5,4,9};
    double[] prices ={100,559.3,150.9};
    double grandTotal =0;

    for(int i=0;i<items.length;i++){
        double total =quantities[i]*prices[i];
        grandTotal+=total;
        invoice.append(String.format("%-15s %-10d %-10.2f %-10.2f\n", items[i], quantities[i], prices[i], total));
    }
    invoice.append("---------------------\n");
    invoice.append(String.format("Grand Total: ",grandTotal));
    invoice.append("Thank you for Shopping with us.Have a good day");
    System.out.println(invoice.toString());
    }
    
}