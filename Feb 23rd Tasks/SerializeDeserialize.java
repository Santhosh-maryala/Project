import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable{
    int id;
    String name;
    double marks;

    Student(int id,String name,double marks){
        this.id=id;
        this.name=name;
        this.marks=marks;
    }
}
public class SerializeDeserialize{
    public static void main(String[] args) {
        
        try {
            Student s1 =new Student(101, "Sandeep", 074.5);
            FileOutputStream fos=new FileOutputStream("student.dat");

            ObjectOutputStream oos =new ObjectOutputStream(fos);

            oos.writeObject(s1);
            oos.close();
            fos.close();
            System.out.println("Object serialized (saved) successfully");
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            
            FileInputStream fis =new FileInputStream("student.dat");

            ObjectInputStream ois =new ObjectInputStream(fis);

            Student s2 = (Student) ois.readObject();

            ois.close();
            fis.close();
            System.out.println("Object deserialized (read) sucessfully");
            System.out.println("ID:" + s2.id);
            System.out.println("Name: " +s2.name);
            System.out.println("Marks:" + s2.marks);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}