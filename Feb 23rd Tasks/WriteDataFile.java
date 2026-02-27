
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDataFile{
    public static void main(String[] args) {
        try {
            FileWriter fw=new FileWriter("sample.txt");
            BufferedWriter bw =new BufferedWriter(fw);

            bw.write("Welcome to Software industry");
            bw.newLine();
            bw.write("This is a sample text file");
            bw.newLine();
            bw.write("Writing data using BufferedWriter");
            bw.newLine();
            bw.write("File content will be overwritten");
            bw.newLine();
            bw.write( "End of file");
            bw.close();
            System.out.println("Data written Succseefully");

            
        } catch (IOException e) {
            System.out.println("An error Occured");
            e.printStackTrace();
        }
    }
}