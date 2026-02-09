
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationErrorCode{
    public static void main(String[] args) {
    List<String> errorCodes =Arrays.asList("ERROR_404","ERROR_500","ERROR_404",
    "ERROR_400","ERROR_403","ERROR_405","ERROR_500");

    Map<String, Integer> freqencyMap =new HashMap<>();
    for(String code: errorCodes){
        freqencyMap.put(code,freqencyMap.getOrDefault(code,0) +1);
    }
    System.out.println("Error Code Counts: ");
    for (Map.Entry<String, Integer> entry : freqencyMap.entrySet()) {
        System.out.println(entry.getKey()+" ->" + entry.getValue());
    }

    String mostFrequentCode =null;
    int maxCount =0;

    for (Map.Entry<String, Integer> entry : freqencyMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentCode = entry.getKey();
            }
        }
        System.out.println("\nMost Frequent Error Code:");
        System.out.println(mostFrequentCode + " occurred " + maxCount + " times");
    }
}

