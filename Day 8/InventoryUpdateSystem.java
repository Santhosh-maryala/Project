class Inventory{
    private int stock =200;

    public void updateStock(int quanity){
        synchronized(this){
            if(stock>=quanity){
                System.out.println(Thread.currentThread().getName() +"  is updating stock");
                stock -=quanity;
                System.out.println(Thread.currentThread().getName()+" updated stock Remaining :"+stock);

            }
            else{
                System.out.println("Not enough sctock for" +Thread.currentThread().getName());
            }
        }
        logUpdate(quanity);
    }public void logUpdate(int quantity){
        System.out.println("Log: " + Thread.currentThread().getName()+ "requested quntity: "+quantity);
    }
    public void checkStock(){
        System.out.println("Current stock s +stock");

    }
}
public class InventoryUpdateSystem{
        public static void main(String[] args) {
            Inventory invt =new Inventory();


            Runnable task =() ->{
                invt.updateStock(27);
            };
            Thread th1 =new Thread(task,"supplier 1 ");
            Thread th2=new Thread(task,"Supplier 2");
            Thread th3=new Thread(task,"Supplier 3");
            th1.start();
            th2.start();
            th3.start();



        }

}