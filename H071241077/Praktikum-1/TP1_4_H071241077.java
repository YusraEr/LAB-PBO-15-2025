import java.util.Scanner;

public class TP1_4_H071241077 {
    
    public static int faktorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * faktorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan bilangan: ");
        int n = scanner.nextInt();
        
        int hasil = faktorial(n);
        
        System.out.println("Output : " + hasil);

        scanner.close();
    }
}

