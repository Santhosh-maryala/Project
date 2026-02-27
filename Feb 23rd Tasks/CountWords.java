
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountWords {
    public static void main(String[] args) {
        
        int wordsCount =0;
        try {
            FileReader fr =new FileReader("sample.txt");
            BufferedReader br =new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) { 
                String[] words =line.split(" ");
                wordsCount +=words.length;
            }
            br.close();

            System.out.println("Total number of Words:" + wordsCount);
            } catch (IOException e) {
                System.out.println("Error reading file:" + e.getMessage());
        } 
    }
}
