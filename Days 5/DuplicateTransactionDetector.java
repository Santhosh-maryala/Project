
import java.util.HashSet;
import java.util.Set;

public class DuplicateTransactionDetector{
    public static void main(String[] args) {
        
        int [] transactions ={123,165,123,82,76,87,82,85,52,87};

        Set<Integer> si =new HashSet<>();
        Set<Integer> duplicates =new HashSet<>();


        for (int id : transactions){
            if(!si.add(id)){
                duplicates.add(id);

            }
        }
        System.out.println(duplicates);
    }

    
}