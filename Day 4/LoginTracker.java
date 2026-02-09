public class LoginTracker{

    static int totalLogin = 0;


    public LoginTracker(String sessionId){
        totalLogin++;

        System.out.println("User logged in with session ID:"+sessionId);
        System.out.println("Total logins so far:"+totalLogin);
        System.out.println("----------------------");
    }
    public static void main(String[] args) 
    {
        new LoginTracker("S001");
        new LoginTracker("S002");
        new LoginTracker("S003");

    }


}