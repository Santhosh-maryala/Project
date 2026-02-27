//Create a File

import java.io.File;
import java.io.IOException;

public class FileCreation{
    public static void main(String[] args){
        try {
            File file =new File("sample.txt");
            if(file.exists()){
                    System.out.println("File already exist");
                }
                else{
                    if(file.createNewFile()){
                        System.out.println("File created Successfuly");
                    }else{
                        System.out.println("File Creation Failed");
                    }
                } 
                System.out.println("Abosolute path:" +file.getAbsolutePath());

                System.out.println("File Size:" +file.length()+ "bytes");
            
        } catch (IOException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }
}