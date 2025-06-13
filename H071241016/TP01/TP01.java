import java.util.Scanner;

public class TP01 {

    public static String kapitalHurufAwal(String kalimat) {
        if (kalimat == null || kalimat.isEmpty()) {
            return kalimat;
        }

        String[] kata = kalimat.split(" ");
        StringBuilder hasil = new StringBuilder();

        for (String k : kata) {
            if (!k.isEmpty()) {
                hasil.append(Character.toUpperCase(k.charAt(0)));
                hasil.append(k.substring(1).toLowerCase());
                hasil.append(" ");
            }
        }

        return hasil.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Judul Film: ");
        String judulFilm = scanner.nextLine();

        String judulKapital = kapitalHurufAwal(judulFilm);
        System.out.println(judulKapital);

        scanner.close();
    }
}