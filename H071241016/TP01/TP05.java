import java.util.Scanner;

public class TP05 {

    public static boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false; 
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        return hasUpper && hasLower && hasDigit; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        if (isValidPassword(password)) {
            System.out.println("YAHHH BETULLL SEKALI");
        } else {
            System.out.println("ND BETUL INI ADEk, ULANGI");
        }

        scanner.close();
    }
}