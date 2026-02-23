
import java.util.Comparator;
import java.util.List;

public class StreamExample{
    public static void main(String[] args) {
        
        List<Integer> number =List.of(28,12,13,44,14,22,5,7,28);
        number.stream().filter(t -> t%2==0).sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}