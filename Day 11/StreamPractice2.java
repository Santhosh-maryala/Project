
import java.util.Arrays;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class StreamPractice2{
    public static void main(String[] args) {
        Integer[] arr ={3,4,5,8,7,5,1};
        Optional<Integer> min =Arrays.stream(arr).filter(n -> n%2==0).min(Integer::compareTo);
        System.out.println(min.orElse(-1));


        
        BinaryOperator<Integer> bo = new BinaryOperator<Integer>(){

            @Override
            public Integer apply(Integer t, Integer u) {
                return t+u;
            } 
        };
        Optional<Integer> sum = Arrays.stream(arr).reduce(bo);
        System.out.println(sum.orElse(-1));
 
        Integer sum1=Arrays.stream(arr).reduce(0,bo);
        System.out.println(sum1);
 
    }
}