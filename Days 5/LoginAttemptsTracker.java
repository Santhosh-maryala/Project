public class LoginAttemptsTracker{
    public static void main(String[] args) {
        int[] loginAttempts={1,4,2,4};

        for(int i=0;i<loginAttempts.length;i++){
            if(loginAttempts[i]>3){
                System.out.println("ALERT: To many failed login attempts!");
            }
        }

    }
}