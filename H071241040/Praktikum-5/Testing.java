import java.util.Scanner;

public class Testing {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== PILIHAN MODE =====");
            System.out.println("1. Pertarungan Antar Hero");
            System.out.println("2. Keluar Game");
            System.out.print("Pilih mode: ");
            int mode;
            try {
                mode = Input.nextInt();
            } catch (Exception e) {
                mode = 2;
            }
            

            if (mode == 2) {
                System.out.println("Terima kasih telah bermain!");
                break;
            }

            System.out.println("\nPilih Hero 1:");
            Hero hero1 = pilihHero(Input);
            if (hero1 == null) continue;

            System.out.println("\nPilih Hero 2:");
            Hero hero2 = pilihHero(Input);
            if (hero2 == null) continue;

            runBattle(hero1, hero2, Input);
        }

        Input.close();
    }

    public static Hero pilihHero(Scanner input) {
        System.out.println("1. Pemanah");
        System.out.println("2. Penyihir");
        System.out.println("3. Fighter");
        System.out.print("Masukkan Opsi Anda: ");
        int pilihan;
        try {
            pilihan = input.nextInt();
        } catch (Exception e) {
            System.out.println("invalid");
            return null;
        }
        

        switch (pilihan) {
            case 1:
                return new Pemanah();
            case 2:
                return new Penyihir();
            case 3:
                return new Fighter();
            default:
                System.out.println("Pilihan tidak valid.");
                return null;
        }
    }

    public static void runBattle(Hero hero1, Hero hero2, Scanner input) {
        while (true) {
            System.out.println("\n===== GILIRAN =====");
            System.out.println("1. " + hero1.Nama + " menyerang");
            System.out.println("2. " + hero2.Nama + " menyerang");
            System.out.println("3. Selesai");
            System.out.print("Pilih aksi: ");
            int aksi;
            try {
                aksi = input.nextInt();
            } catch (Exception e) {
                System.out.println("Inputan Invalid");
                return;
            }
            

            switch (aksi) {
                case 1:
                    hero1.serang(hero2);
                    break;
                case 2:
                    hero2.serang(hero1);
                    break;
                case 3:
                    System.out.println("Pertarungan selesai.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

            if (hero1.Health <= 0 || hero2.Health <= 0) {
                System.out.println("Pertarungan berakhir! Salah satu hero kehabisan darah.");
                return;
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
        System.out.println(Nama + " menyerang dengan kekuatan " + attackPower + "!");
    }

    public void serang(Hero musuh) {
        System.out.println(Nama + " menyerang " + musuh.Nama + " dengan kekuatan " + attackPower + "!");
        musuh.Health -= attackPower;
        if (musuh.Health < 0) musuh.Health = 0;
        System.out.println("Health " + musuh.Nama + " sekarang: " + musuh.Health);
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
        super("Fighter", 200, 30);
    }
}
 
    

