import java.util.Scanner;

public class TP1_4_H071201040{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan bilangan faktorial Anda : ");
        long angka = input.nextInt();
        if (angka <= 0){
            System.out.println("tidak tedefinisi 0 dan negatif");
        }else{
            System.out.println(fak(angka));
            input.close();
        }
     } 
    public static long fak(long n){
        if (n == 1 ){
            return 1;
        }else{
            return n * fak(n-1);
        }
    }  
}  
    
