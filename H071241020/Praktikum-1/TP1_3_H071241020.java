package TP_1;

import java.util.Scanner;

public class TP1_3_H071241020 {
    static final String[] NAMA_BULAN = {
        "Januari", "Februari", "Maret", "April", "Mei", "Juni",
        "Juli", "Agustus", "September", "Oktober", "November", "Desember"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan tanggal (dd-mm-yy): ");
        String input = scanner.nextLine().trim();
        
        try {
            String[] parts = input.split("[-]");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Format tanggal tidak valid");
            }
            
            int hari = Integer.parseInt(parts[0]);
            int bulan = Integer.parseInt(parts[1]);
            int tahun = Integer.parseInt(parts[2]);
            
            if (bulan < 1 || bulan > 12) {
                throw new IllegalArgumentException("Bulan harus antara 1-12");
            }
            if (hari < 1 || hari > 31) {
                throw new IllegalArgumentException("Hari harus antara 1-31");
            }
            
            int tahun4Digit = (tahun < 25) ? 2000 + tahun : 1900 + tahun;
            
            String output = hari + " " + NAMA_BULAN[bulan-1] + " " + tahun4Digit;
            System.out.println("Output: " + output);
            
        } catch (NumberFormatException e) {
            System.out.println("Error: Format angka tidak valid");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}