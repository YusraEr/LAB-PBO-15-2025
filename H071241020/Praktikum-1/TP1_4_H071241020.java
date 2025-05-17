package TP_1;

import java.util.Scanner;

public class TP1_4_H071241020 {

    public static int hitungFaktorial(int n) {
        if (n == 0 || n == 1) { 
            return 1;
        } else { 
            return n * hitungFaktorial(n - 1);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan bilangan n: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Input tidak valid. Masukkan bilangan bulat non-negatif.");
        }else {
            int hasil = hitungFaktorial(n);

            System.out.println("Output: " + hasil);
        }scanner.close();
    }
    
}
