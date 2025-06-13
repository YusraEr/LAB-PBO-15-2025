import java.util.Scanner;

public class perbaikan{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan tanggal dalam format dd-mm-yyyy: ");
        String inputTanggal = scanner.nextLine();
        String[] tanggal = inputTanggal.split("-");
        String bulan_baru = "";



        if (tanggal.length != 3) { 
            System.out.println("Format tanggal tidak valid.");
            return; 
        }

        try {
            int hari = Integer.parseInt(tanggal[0]);
            int bulan = Integer.parseInt(tanggal[1]);
            if (bulan == 1){
                bulan_baru = "januari";
            }else if (bulan == 2){
                bulan_baru = "februari";
            }else if (bulan == 3){
                bulan_baru = "maret";  
            }else if (bulan == 4){
                bulan_baru = "april";
            }else if (bulan == 5){
                bulan_baru = "mei"; 
            }else if (bulan == 6){
                bulan_baru = "juni";
            }else if (bulan == 7){
                bulan_baru = "juli";
            }else if (bulan == 8){
                bulan_baru = "agustus";
            }else if (bulan == 9){
                bulan_baru = "september"; 
            }else if (bulan == 10){
                bulan_baru = "oktober";
            }else if (bulan == 11){
                bulan_baru = "november";
            }else if (bulan == 12){
                bulan_baru = "desember";
            }
            int tahun = Integer.parseInt(tanggal[2]);
            
          System.out.println(hari +" "+ bulan_baru +" " +tahun);
        } catch (NumberFormatException e) {
            System.out.println("Format tanggal tidak valid.");
        }
    }
}