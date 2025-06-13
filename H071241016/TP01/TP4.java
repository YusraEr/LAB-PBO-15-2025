import java.util.Scanner;

public class TP4 {

    public static int faktorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * faktorial(n - 1); 
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("nd boleh bilangan negatif adekk soalnya ak pusing !!!!.");
        } else {
            int hasil = faktorial(n);
            System.out.println("Output: " + hasil);
        }

        scanner.close();
    }
}