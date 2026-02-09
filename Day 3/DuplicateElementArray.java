
import java.util.HashSet;



public class DuplicateElementArray
{

    public static void main(String[] args) 
    {
        /*
        String arr[] = {"java","python","java","c++","c++"};

        boolean flag=false;

        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[i].equals(arr[j]))
                {
                    System.out.println("Found Duplicate Element:" + arr[i]);
                    flag=true;
                }

            }
        }
        if(flag==false)
        {
            System.out.println("Duplicate element not found");
            
        } */

        //Approach 2 Hashset

       String arr[] = {"java","python","java",".net","c++"};

       HashSet <String>langs =new HashSet();
       boolean flag=false;

       for(String l:arr)
       {
        if (langs.add(l)==false)
        {
            System.out.println("Found Duplicate Elements:" +l);
            flag=true;
        }
       }
       if (flag==false)
       {
        System.out.println("Duplicate elements not found");
       }


    }

}




    
