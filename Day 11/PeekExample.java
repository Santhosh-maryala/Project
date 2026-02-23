
import java.util.Arrays;
import java.util.List;

public class PeekExample{
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Pavan Kalyan","Ramcharan","Mahesh Babu","Junior NTR","Venky");
        
        names.stream()
                .peek(name -> System.out.println("Orginal :"+name))
                .map(String :: toUpperCase)
                .peek(name -> System.out.println("Uppercase:"+name))
                .forEach(System.out::println);
    }

}