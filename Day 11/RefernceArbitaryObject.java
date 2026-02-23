
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RefernceArbitaryObject{
    public static void main(String[] args) {
        List<String> names =Arrays.asList("Vamshi","Naveen","Anudeep","Jamse Bond");
        Collections.sort(names,String::compareTo);
        names.forEach(System.out::println);
    }
}