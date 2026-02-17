import java.util.Scanner;

public class UserNameGenerate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full name: ");
        String fullName = sc.nextLine();

        fullName = fullName.toLowerCase();

        fullName = fullName.replace(" ", "");

        String username = "";
        for (int i = 0; i < fullName.length(); i++) {
            char ch = fullName.charAt(i);

            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                username = username + ch;
            }
        }

        System.out.println("Generated Username: " + username);


        sc.close();
    }
}
