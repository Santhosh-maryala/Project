class SalesReport extends Thread{
    @Override
    public void run(){
        System.out.println("Sales Report generated Started...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
        System.out.println("Sales Reports Generated..");
    }
}
class InventoryReport extends Thread{
    @Override
    public void run(){
        System.out.println("InventoryReports generated started");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Inventory report generated");
        }
    }
    class profitReport extends Thread{
        @Override
        public void run(){
            System.out.println("Profit report generation strted..");
            try {
                Thread.sleep(3500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Profit Report geerated");
        }
    }
    public class ReportGenerationSystem{
        public static void main(String[] args) {
            SalesReport salr =new SalesReport();
            InventoryReport invry =new InventoryReport();
            profitReport pfrt= new profitReport();
            salr.start();
            invry.start();
            pfrt.start();

            try {
                salr.join();
                invry.join();
                pfrt.join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("All reports completed");
        }

    }
