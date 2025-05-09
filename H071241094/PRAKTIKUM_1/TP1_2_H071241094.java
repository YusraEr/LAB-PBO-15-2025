import java.util.Scanner;

public class TP1_2_H071241094 {
    public static void main(String[] args) {
        int[][] nums = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        try (Scanner scanner = new Scanner(System.in)) { 
            System.out.print("Masukkan angka yang ingin dicari: ");
            int target = scanner.nextInt();

            boolean found = false;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    if (nums[i][j] == target) {
                        System.out.println("Angka " + target + " ditemukan pada posisi [" + i + "][" + j + "]");
                        found = true;
                        break; 
                    }
                }
                if (found) break; 
            }

            if (!found) {
                System.out.println("Angka " + target + " tidak ditemukan dalam array.");
            }

        } catch (Exception e) {
            System.out.println("Input tidak valid! Harap masukkan bilangan bulat.");
        }
    }
}
