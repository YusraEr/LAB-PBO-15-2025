import java.util.Scanner;

public class TP1_3_H071241094 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] months = {"Januari", "Februari", "Maret", "April", "Mei", "Juni",
                           "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        
        System.out.print("Masukkan tanggal (dd-mm-yy): ");
        String date = scanner.nextLine();
        // memisahkan
        String[] parts = date.split("-");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]) - 1;  
        int year = Integer.parseInt(parts[2]);

        if (year < 50) {
            year += 2000; 
        } else {
            year += 1900; 
        }

        System.out.println(day + " " + months[month] + " " + year);

        scanner.close();
    }
}


