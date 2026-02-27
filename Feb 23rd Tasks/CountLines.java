
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountLines{
    public static void main(String[]args){
        int lineCount=0;
        try{
            FileReader fr =new FileReader("sample.txt");
            BufferedReader br = new BufferedReader(fr);
            
            while (br.readLine()!=null) {
                lineCount++;   
            }
            br.close();
            System.out.println("Total number of lines: " + lineCount);
        }
        catch(IOException e){
            System.out.println("Error reading file:" +e.getMessage());
        }
    }
}