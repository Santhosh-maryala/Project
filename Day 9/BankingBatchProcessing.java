
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class IntrestCalculator implements Callable<Double>{
    private int accountNumber;
    private double balance;
    private double rate;

    public IntrestCalculator(int accountNumber,double balance,double rate){
    this.accountNumber=accountNumber;
    this.balance=balance;
    this.rate=rate;
    }
    @Override
    public Double call() throws Exception{
        String threadName =Thread.currentThread().getName();
        System.out.println("Calculating Intrest for Account"+accountNumber+" using"+threadName);
        Thread.sleep(2000);
        double interest =balance*rate/100;
        System.out.println("Interest Calculated for Account"+accountNumber+ " = "+interest);
        return interest;
    }
}
public class BankingBatchProcessing{
    public static void main(String[] args) throws Exception{
        ExecutorService executor =Executors.newFixedThreadPool(3);
        List<Future<Double>> futureList =new ArrayList<>();
        double[][]account ={ {100,1000,4} ,{101,2000,5},{105,3000,6.5},{108,299,4.4},{106,290,3.4}};

        for(double[] acc : account){
            Callable<Double> task = new IntrestCalculator((int) acc[0],acc[1],acc[2]);
            Future<Double>future =executor.submit(task);
            futureList.add(future);
            }
            System.out.println(" Collecting Results ..");

            double totalIntrest =0;
            for(Future<Double>future : futureList){
                double interest =future.get();
                totalIntrest += interest;
            }
            System.out.println("Total interest for all account ="+totalIntrest);
            executor.shutdown();
    }
}