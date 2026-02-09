public class ArmStrongNumber{
    public static void main(String[] args) {
        int num=153, result=0, rem;
        int temp=num;

        while(num>0){
            rem=num%10;
            num=num/10;
            result=result+(rem*rem*rem);
        }
        if (result==temp)
        {
            System.err.println("ArmstrongNumber");
        }
        else{
            System.err.println("Not a ArmstrongNumber");
        }

    }
}