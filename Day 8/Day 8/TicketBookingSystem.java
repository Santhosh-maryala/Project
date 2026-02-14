
class TicketBooking{
    int tickets=10;

    public synchronized void bookTicket(String user,int num){
        if (tickets>= num){
            System.out.println(user +" is booking" + num + "tickets..");
            tickets -= num;
            System.out.println("Tickets left :" +tickets);
           }else {
            System.out.println(user +"tried to book but not enough tickets");
           }
        }        
    }
    class User extends Thread{
        TicketBooking booking;

        User(TicketBooking booking,String name){
            super(name);
            this.booking=booking;
        }
        @Override
        public void run(){
            booking.bookTicket(getName(), 3);
        }
    }
    public class TicketBookingSystem{
        public static void main(String[] args) {
            TicketBooking booking=new TicketBooking();
            
            for(int i=1;i<=5;i++){
                new User(booking,"User"+i).start();
            }
        }
}