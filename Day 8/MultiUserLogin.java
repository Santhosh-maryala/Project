
import java.util.Date;

class LoginTask implements Runnable{
    private  String username;

    public LoginTask(String username){
    this.username =username;
    }
    @Override
    public void run(){
        try {
            System.out.println(new Date()+"|" +username+"Attempting login");
            Thread.sleep(2000);
            System.out.println(new Date()+"|" +username+"Successfully logged in");
        } catch (InterruptedException e) {
            System.out.println(username+"login interrupted");
            }
        }
    }
    public class MultiUserLogin{
        public static void main(String[] args) {
            System.out.println("Starting Login Simulation(100 Users,10 Threads)");

            for (int i = 0; i <=100; i++) {
                LoginTask task =new LoginTask("User "+i);

                Thread thread =new Thread(task);

                System.out.println("Thread"+i+ "state: "+ thread.getState());
                thread.start();
                
                System.out.println("->" + thread.getState());
            }
            System.out.println("All login requests submitted");
        }
    }