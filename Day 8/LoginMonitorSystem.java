
class LogScanner extends Thread{

    @Override
    public void run(){
        try {
            
            for(int i=1;i<=3;i++){
                System.out.println("Scanning logs... Cycles"+ i);
                Thread.sleep(5000);
                System.out.println("Completed Cycle" +i);
            }
        } catch (InterruptedException e) {
            System.out.println("Scanner interrupted");
        }
    }
}
public class LoginMonitorSystem{
    public static void main(String[] args) throws InterruptedException{
        LogScanner sc=new LogScanner();
        System.out.println("Start after creation :" +sc.getState());
        sc.start();
        for(int i=1;i<=8;i++){
            Thread.sleep(2000);
            System.out.println("Current thread state: "+ sc.getState());    
            } 
        }
}