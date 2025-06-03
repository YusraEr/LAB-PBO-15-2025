package leagueOfHero;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("=== chose your char ===");
            System.out.println("1. archer\n" + "2. wizard\n" + "3. fighter\n" + "4. exit");
            System.out.print("masukkan pilihan: ");
            int choseChar = sc.nextInt();

            if (choseChar == 4) {
                break;
            }

            System.out.println("\n=== chose action ===");
            System.out.println("1. attack\n" + "2. exit");
            System.out.print("pilih aksi: ");
            int choseAction = sc.nextInt();
            
           
            if (choseAction == 2){
                break;
            }

            switch (choseChar) {
                case 1:
                    Archer archer = new Archer("pemanah", 100, 15);
                    archer.attack();
                    break;
                case 2:
                    Wizard wizard = new Wizard("penyihir", 100, 20);
                    wizard.attack();
                    break;
                case 3:
                    Fighter fighter = new Fighter("petarung", 100, 18);
                    fighter.attack();
                    break;
            }

        }
        
    }
}
