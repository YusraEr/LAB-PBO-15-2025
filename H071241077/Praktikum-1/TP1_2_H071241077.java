// import java.util.Scanner;

// public class TP1_2_H071241077 {
//     public static void main(String[] args) {
//         int[][] nums = {
//             {1, 2, 3},
//             {4, 5, 6},
//             {7, 8, 9}
//         };

//         try (Scanner scanner = new Scanner(System.in)) {
//             System.out.print("Masukkan angka yang ingin dicari: ");
//             int target = scanner.nextInt();

//             boolean found = false;
//             for (int i = 0; i < nums.length; i++) {
//                 for (int j = 0; j < nums[i].length; j++) {
//                     if (nums[i][j] == target) {
//                         System.out.println("Angka " + target + " ditemukan pada posisi [" + i + "][" + j + "]");
//                         found = true;
//                         break;
//                     }
//                 }
//                 if (found) break;
//             }
            
//             if (!found) {
//                 System.out.println("Angka " + target + " tidak ditemukan dalam array.");
//             }

//         } catch (Exception e) {
            
//             System.out.println("Input tidak valid! Harap masukkan bilangan bulat.");
//         }
//     }
// }

//PERBAIKAN (PAKAI INPUT RANDOM)
import java.util.Scanner;
import java.util.Random;

public class TP1_2_H071241077 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int[][] nums = new int[3][3];

        for (int n = 0; n < 3; n++) {
            for (int k = 0; k < 3; k++) {
                nums[n][k] = random.nextInt(9) + 1;
            }
        }

        System.out.println("Array 3x3 yang dihasilkan:");
        for (int n = 0; n < 3; n++) {
            for (int k = 0; k < 3; k++) {
                System.out.print(nums[n][k]);
            }
            System.out.println();
        }

        try {
            System.out.print("Input satu bilangan bulat: ");
            int bil = input.nextInt();

            boolean found = false;

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    if (nums[i][j] == bil) {
                        System.out.println("Found " + bil + " at [" + i + "][" + j + "]");
                        found = true;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }

            if (!found) {
                System.out.println("Bilangan tidak ditemukan dalam array");
            }
        } catch (Exception e) {
            System.out.println("Masukkan bilangan bulat");
        } finally {input.close();}
    }
}



