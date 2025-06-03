import java.util.Scanner;

public class Nomor5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        if (isPasswordValid(password)) {
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }

        scanner.close();
    }

    public static boolean isPasswordValid(String password) {
        // Cek panjang password minimal 8 karakter
        if (password.length() < 8) {
            return false;
        }

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            }

            // Jika semua syarat sudah terpenuhi, keluar dari loop
            if (hasUppercase && hasLowercase && hasDigit) {
                break;
            }
        }

        // Kembalikan true hanya jika semua syarat terpenuhi
        return hasUppercase && hasLowercase && hasDigit;
    }
}