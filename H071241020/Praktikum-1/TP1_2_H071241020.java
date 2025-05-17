package TP_1;

import java.util.Scanner;

public class TP1_2_H071241020 {

    public static void main(String[] args) {
        int[][] nums = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Masukkan angka yang ingin dicari: ");
            int target = scanner.nextInt();

            boolean ditemukan = false;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    if (nums[i][j] == target) {
                        System.out.println("Found " + target + " at [" + i + "][" + j + "]");
                        ditemukan = true;
                        break; 
                    }
                }
                if (ditemukan) {
                    break; 
                }
            }

            if (!ditemukan) {
                System.out.println("Angka " + target + " tidak ditemukan dalam array.");
            }
        } catch (Exception e) {
            System.out.println("Input tidak valid. Harap masukkan bilangan bulat.");
        } finally {
            scanner.close();
        }
    }
}

