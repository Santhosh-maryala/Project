
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AppendFile {
    public static void main(String[] args) {
        try {
            FileWriter fw =new FileWriter("sample.txt",true);

            BufferedWriter br=new BufferedWriter(fw);

            br.newLine();

            br.write("Append line this line is added without deleting old content ");
            br.close();
            System.out.println("Data appended successfully");

        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}
