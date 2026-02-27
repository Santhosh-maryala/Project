import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchWordsInFile {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String fileName = input.nextLine();

        System.out.print("Enter word to search: ");
        String word = input.nextLine();

        try {
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);

            int lineNumber = 0;
            boolean found = false;

            while (fileReader.hasNextLine()) {
                lineNumber++; 
                String line = fileReader.nextLine();

               
                if (line.contains(word)) {
                    System.out.println("Word found at line: " + lineNumber);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Word not found in the file.");
            }

            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        input.close();
    }
}