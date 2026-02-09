
import java.util.Arrays;

public class AnagramCheck{
    public static void main(String[] args){

        String name1="hello";
        String name2="oehll";

        char [] c1 = name1.toCharArray();
        char [] c2 = name2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if(Arrays.equals(c1,c2)==true)
        {
            System.out.println("They are anagram");
        }
        else{
            System.err.println("They are not anagram");
        }
    }
}