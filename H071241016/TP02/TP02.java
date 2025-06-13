import java.util.Scanner;

public class TP02 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Masukkan angka yang ingin dicari: ");
            int angkaCari = scanner.nextInt();
            int[][] nums = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            };


            System.out.println("Array 2D:");
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    System.out.print(nums[i][j] + " ");
                }
                System.out.println();
            }

            boolean ditemukan = false;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    if (nums[i][j] == angkaCari) {
                        System.out.println("Ditemukan " + angkaCari + " di [" + i + "][" + j + "]");
                        ditemukan = true;
                        break; 
                    }
                }
                if (ditemukan) {
                    System.out.println("oke");
                    break; 
                }
            }

            if (!ditemukan) {
                System.out.println(angkaCari + " tidak ditemukan dalam array.");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}