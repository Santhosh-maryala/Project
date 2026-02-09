public class BillingTypeCasting
{
    public static void main(String[] args) 
        {
            double amount = 69.73;
            //Explicit casting

            int storedAmount = (int) amount;
            System.out.println("Received amount (double) : "+ amount);
            System.out.println("Stored amount (int):"+storedAmount);

            if(amount != storedAmount)
            {
                System.out.println("WARNING: Precision loss occured!");
            }
            //implicit Casting

            int Cash = 50;
            double paidCash= Cash;
            System.out.println("Implicit casting example(int -> double) :" + paidCash);

        }
    

}