import java.util.Random;
import java.util.Scanner;

public class TP1_2_H071201040{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int baris = 3, kolom = 3;
        int[][] barisan = new int[baris][kolom];

        for (int i = 0; i < baris ; i++){
            for (int j = 0; j < kolom ; j++){
                barisan[i][j] = random.nextInt(9)+1;
            }
        }
        // System.out.println("Array asli:");
        // for (int i = 0; i < baris; i++) {
        //     for (int j = 0; j < kolom; j++) {
        //         System.out.print(barisan[i][j]);
        //     }
        //     System.out.println();
        // }
        try {
            System.out.println("Masukkan angka yang ingin dicari :");
            int target = input.nextInt();
            boolean ditemukan = false;
            for(int i = 0; i < baris; i++){
                for(int j=0; j< kolom; j ++){
                    if(barisan[i][j] == target){
                        System.out.println("ditemukan " + target + " di [" + i + "][" + j + "]");
                        ditemukan = true;
                        break;
                    }
                if (ditemukan) break;
            }
        }
            if (!ditemukan) {
                System.out.println("Angka tidak ditemukan.");
            }
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }finally{
   
            
            input.close();
             }
        }
}

