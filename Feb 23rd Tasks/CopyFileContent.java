
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class CopyFileContent{
    public static void main(String[] args) {
        String SourceFile="Source.txt";
        String destinationFile ="destination.txt";
        
        try{
            BufferedReader r =new BufferedReader(new FileReader(SourceFile));
            BufferedWriter w = new BufferedWriter(new FileWriter(destinationFile));

            String line;

            while((line = r.readLine())!=null){
                w.write(line);
                w.newLine();
            }
            r.close();
            w.close();
            System.out.println("File copied successfully");
        } catch(IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}