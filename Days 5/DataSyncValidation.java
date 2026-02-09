
import java.util.Arrays;

public class DataSyncValidation{
    public static void main(String[] args) {
        
        int [] source ={20,37,64,89,37,90,35};
        int [] destination={20,37,40,50,37,70,90};
        
        if(Arrays.equals(source, destination)){
            System.out.println("Arrays are identical");

        }   
        else{
            System.out.println("Arrays ae not Identical");
            for(int i=0;i<source.length;i++){
                if(source[i]!=destination[i]){
                    System.out.println("Mismatch at index " + i + " : Source = " + source[i] + ", Destination = " + destination[i]);

                }
            }


        } 
    }   
}