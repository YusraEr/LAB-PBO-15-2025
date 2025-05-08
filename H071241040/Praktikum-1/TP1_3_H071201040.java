import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class TP1_3_H071201040{
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        System.out.println("Masukkan tanggal (dd-mm-yy): ");
        System.out.println("Contoh '15 - 05 - 13'");
        System.out.print("Input : ");

        String tanggal = Input.nextLine().replaceAll("\\s", "");
        
        try {
            SimpleDateFormat FormatAwal = new SimpleDateFormat("d-M-yy");
            Date date = FormatAwal.parse(tanggal);
            
            SimpleDateFormat FormatAkhir = new SimpleDateFormat("d MMMM yyyy");
            String terFormat = FormatAkhir.format(date);
            
            System.out.println("Output: " + terFormat);
        } catch (Exception e) {
            System.out.println("Format tanggal tidak valid!");
        } finally {
            Input.close();
        }
    }
}
