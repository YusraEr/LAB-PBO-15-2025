import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TP03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan tanggal dalam format dd-mm-yy: ");
        String inputTanggal = scanner.nextLine();

        try {
            DateTimeFormatter formatterInput = DateTimeFormatter.ofPattern("dd-MM-yy");
            LocalDate tanggal = LocalDate.parse(inputTanggal, formatterInput);

            DateTimeFormatter formatterOutput = DateTimeFormatter.ofPattern("d MMMM yyyy");
            String tanggalOutput = tanggal.format(formatterOutput);

            System.out.println("Output: " + tanggalOutput);
        } catch (Exception e) {
            System.out.println("Format tanggal tidak valid.");
        }

        scanner.close();
    }
}