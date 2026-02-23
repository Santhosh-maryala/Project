
import java.util.Arrays;
import java.util.List;

public class ReferenceStaticMethod{
    public static void main(String[] args) {
        List<String> names =Arrays.asList("Pavan kalyan","Mahesh babu");
        names.forEach(ReferenceStaticMethod::greet); //Method refernce static 
    }
    public static void greet(String names){
        System.out.println("Hey Hello,My name is " +names);

    }
}

