import java.util.Scanner;

public class TP1_4_H071241094 {

    public static int factorial(int n) {
        if (n == 0 || n == 1) {  
            return 1;
        } else {          
            return n * factorial(n - 1); 
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan angka: ");
        int n = scanner.nextInt();
        
        int result = factorial(n);
        System.out.println("Hasil " + n + "! = " + result);
    
        scanner.close();
    }
}





