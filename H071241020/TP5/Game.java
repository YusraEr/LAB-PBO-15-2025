package TP5;
import java.util.Scanner;

public class Game {
    public void mulai() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== PILIH KARAKTER ===");
        System.out.println("1. Archer");
        System.out.println("2. Wizard");
        System.out.println("3. Fighter");
        System.out.print("Masukkan pilihan (1-3): ");
        int pilihan = scanner.nextInt();

        Hero hero;

        switch (pilihan) {
            case 1:
                hero = new Archer();
                break;
            case 2:
                hero = new Wizard();
                break;
            case 3:
                hero = new Fighter();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                scanner.close();
                return;
        }

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Serang");
            System.out.println("2. Keluar");
            System.out.print("Pilih menu: ");
            int menu = scanner.nextInt();

            if (menu == 1) {
                hero.serang();
            } else if (menu == 2) {
                System.out.println("Game selesai!");
                break;
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }

        scanner.close();
    }
}
