import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MergeTwoFiles {
    public static void main(String[] args) {
        try {
            FileReader fr1 =new FileReader("file1.txt");
            FileReader fr2 = new FileReader("file2.txt");
            
            BufferedReader br1 =new BufferedReader(fr1);
            BufferedReader br2 =new BufferedReader(fr2);

            FileWriter fw = new FileWriter("merged.txt");
            BufferedWriter bw =new BufferedWriter(fw);

            String line;

           while((line =br1.readLine())!=null){
                bw.write(line);
                bw.newLine();
            }
            while((line =br2.readLine())!=null){
                bw.write(line);
                bw.newLine();
            }
            br1.close();
            br2.close();
            bw.close();

            System.out.println("File merged Successfully into merged.txt");
    
        } catch (IOException e) {
            System.out.println("Error: " +e.getMessage());
        }
    }
}
