import java.util.Scanner;

public class TP1_1_H071241094 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Masukkan Judul Film: ");
        String input = s.nextLine();


        String hasil = "";
        for (String kata : input.split(" ")){
            hasil += kata.substring(0, 1).toUpperCase() + kata.substring(1).toLowerCase() + " ";
        }
        System.out.println("Judul setelah perubahan: " + hasil.trim());
        s.close();
    }
}
