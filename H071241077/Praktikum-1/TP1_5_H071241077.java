// import java.util.Scanner;

// public class Nomor_5 {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.print("Masukkan password: ");
//         String password = scanner.nextLine();
//         scanner.close();

//         if (password.length() >= 8 && 
//             password.matches(".*[A-Z].*") && 
//             password.matches(".*[a-z].*") && 
//             password.matches(".*[0-9].*")) {
//             System.out.println("Output : Password valid");
//         } else {
//             System.out.println("Output : Password tidak valid");
//         }
//     }
// }

//PERBAIKAN (TANPA REGEX):
import java.util.Scanner;

public class TP1_5_H071241077 {
    public static boolean CekPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean adaHurufBesar = false;
        boolean adaHurufKecil = false;
        boolean adaAngka = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                adaHurufBesar = true;
            } else if (Character.isLowerCase(c)) {
                adaHurufKecil = true;
            } else if (Character.isDigit(c)) {
                adaAngka = true;
            }

            if (adaHurufBesar && adaHurufKecil && adaAngka) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan password: ");
        String password = input.nextLine();
        input.close();

        if (CekPassword(password)) {
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }
    }
}

