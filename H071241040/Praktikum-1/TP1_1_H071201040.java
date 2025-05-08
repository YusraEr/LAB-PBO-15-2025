import java.util.Scanner;
public class TP1_1_H071201040 {
    public static void main(String[] args) {
        Scanner text = new Scanner(System.in);
        System.out.println("Masukkan Judul Film : ");
        String judul = text.nextLine();

        String[] kata = judul.split(" ");
        String katabaru  = "";

        for (int i = 0; i < kata.length; i++){
            if (kata[i].length()> 0){
                katabaru += kata[i].substring(0, 1).toUpperCase() + kata[i].substring(1).toLowerCase()+" ";
            }
        }
    System.out.println("Judul film setelah di edit: " + katabaru.trim());
    text.close();
    }
    
}