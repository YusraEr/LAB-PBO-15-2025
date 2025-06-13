import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        Hero hero = null;

        System.out.println("===== Pilih Hero Anda =====");
        System.out.println("1. Pemanah");
        System.out.println("2. Penyihir");
        System.out.println("3. Fighter");
        System.out.print("Masukkan Opsi Anda : ");
        int pilihan;

        try {
            pilihan = Input.nextInt();
        } catch (Exception e) {
            System.out.println("Pilihan tidak valid.");
            Input.close();
            return;
        }


        switch(pilihan){
            case 1:
                hero = new Pemanah();
                break;
            case 2:
                hero = new Penyihir();
                break;
            case 3:
                hero = new Fighter();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                Input.close();
                return;
        }

        runApp(hero, Input);
        Input.close();
    }

    public static void runApp(Hero hero, Scanner Input) {
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Serang");
            System.out.println("2. Keluar");
            System.out.print("Pilih Aksi: ");
            int pilih;

            try{
                pilih = Input.nextInt();
            } catch (Exception e) {
                System.out.println("Pilihan tidak valid.");
                return;
            }

            switch (pilih) {
                case 1:
                    hero.Attack();
                    break;
                case 2:
                    System.out.println("Game Selesai !");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}

class Hero {
    String Nama;
    int Health;
    int attackPower;

    public Hero(String Nama, int Health, int attackPower){
        this.Nama = Nama;
        this.Health = Health;
        this.attackPower = attackPower;
    }

    public void Attack(){
        System.out.println(Nama + " Menyerang dengan kekuatan " + attackPower + "!");
    }
}

class Pemanah extends Hero {
    public Pemanah() {
        super("Pemanah", 200, 15);
    }
}

class Penyihir extends Hero {
    public Penyihir() {
        super("Penyihir", 200, 20);
    }
}

class Fighter extends Hero {
    public Fighter() {
        super("Fighter", 200, 18);
    }
}