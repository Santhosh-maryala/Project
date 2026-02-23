
import java.util.function.Consumer;


public class RefernceInstanceParticularObject{
    public static void main(String[] args) {

        Message mg =new Message();
        Consumer<String> con = mg :: display;
        con.accept("Hello this is refernce instance particular object method");
    }
}
    class Message{
        public  void display(String msg){
            System.out.println(msg);
        }
    }
 
    

    