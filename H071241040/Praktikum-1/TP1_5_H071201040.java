import java.util.Scanner;

public class TP1_5_H071201040 {
    public static boolean isValidPassword(String password) {
        boolean hasUpper = false, hasLower = false, hasDigit = false;
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            if (Character.isLowerCase(ch)) hasLower = true;
            if (Character.isDigit(ch)) hasDigit = true;
        }
        return hasUpper && hasLower && hasDigit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();
        boolean minimalChar = password.length() < 8;

        if (minimalChar) { System.out.println("Password tidak valid! Minimal 8 Karakter");}
        else if (isValidPassword(password)) { System.out.println("Password valid");}
        else { System.out.println("Password tidak valid! Password harus mengandung huruf kecil, huruf besar, dan angka.");}

        scanner.close();
    }
}
