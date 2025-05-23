import java.util.Scanner;

public class Nomor4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan bilangan n: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Faktorial tidak terdefinisi untuk bilangan negatif.");
        } else {
            long result = factorial(n);
            System.out.println("Output: " + result);
        }

        scanner.close();
    }

    // Method rekursif untuk menghitung faktorial
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}