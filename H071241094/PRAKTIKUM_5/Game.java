import java.util.Scanner;

class Hero {
    String name;
    int health;
    int attackPower;

    public Hero(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }
    public void attack() {
        System.out.println(name + " menyerang dengan kekuatan " + attackPower + "!");
    }
}

class Archer extends Hero {
    public Archer(String name, int health, int attackPower) {
        super(name, health, attackPower); 
    }
    @Override
    public void attack() {
        System.out.println(name + " menyerang dengan kekuatan " + attackPower + "!");
    }
}

class Wizard extends Hero {
    public Wizard(String name, int health, int attackPower) {
        super(name, health, attackPower); 
    }
    @Override
    public void attack() {
        System.out.println(name + " menyerang dengan kekuatan " + attackPower + "!");
    }
}

class Fighter extends Hero {
    public Fighter(String name, int health, int attackPower) {
        this(name,health);
        this.attackPower = attackPower;
    }
    public Fighter(String name, int health) {
        super(name, health,10); 
    }
    @Override
    public void attack() {
        System.out.println(name + " menyerang dengan kekuatan " + attackPower + "!");
    }
}

public class Game {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Hero selectedHero = null;

            System.out.println("Pilih Karakter: ");
            System.out.println("1. Archer");
            System.out.println("2. Wizard");
            System.out.println("3. Fighter");
            System.out.print("Masukkan pilihan: ");
            int pilihanKarakter = scanner.nextInt();
            
            switch (pilihanKarakter) {
                case 1:
                    selectedHero = new Archer("Pemanah", 100, 15);
                    break;
                case 2:
                    selectedHero = new Wizard("Penyihir", 80, 20);
                    break;
                case 3:
                    selectedHero = new Fighter("Petarung", 120, 18);
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    return;
            }
            int aksi;
            do {
                System.out.println("Menu: ");
                System.out.println("1. Serang");
                System.out.println("2. Keluar");
                System.out.print("Pilih aksi: ");
                aksi = scanner.nextInt();

                if (aksi == 1) {
                    selectedHero.attack();
                } else if (aksi == 2) {
                    System.out.println("Game selesai!");
                } else {
                    System.out.println("Aksi tidak valid!");
                }
            } while (aksi != 2);

        } 
    }
}