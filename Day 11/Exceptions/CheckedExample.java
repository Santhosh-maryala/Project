
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExample{
    public static void main(String[] args) {
        try{
            FileReader file =new FileReader("data.txt");
            BufferedReader br =new BufferedReader(file);
            System.out.println(br.readLine());
            br.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not Found");
        }
        catch(IOException e){
            System.out.println("Io Error occured");
        }
    }
}