class Senjata {
    String nama;
    int damage;


    Senjata(String nama, int damage) {
        this.nama = nama; 
        this.damage = damage; 
        }
    
    void info() { 
        System.out.println("Senjata: " + nama + " (Damage: " + damage + ")"); 
    }
}

class Rekan {
    String nama;
    String kemampuan;

    Rekan(String nama, String kemampuan) { 
        this.nama = nama; 
        this.kemampuan = kemampuan; 
    }

    void info() {
        System.out.println("Rekan: " + nama + " (Skill: " + kemampuan + ")"); 
    }

    void bantuPemain(Pemain pemain) {
        System.out.println(nama + " menggunakan " + kemampuan + " pada " + pemain.nama + ".");
        if (kemampuan.equalsIgnoreCase("Healing")) 
        pemain.health += 30;
    }
}

class Zombie {
    int health = 100;
    int damage = 25;

    void serangPemain(Pemain pemain) {
        System.out.println("Zombie serang " + pemain.nama +  " dengan damage " + damage );
        pemain.terimaDamage(damage);
    }
}

class Pemain {
    String nama;
    int health;
    Senjata senjata;
    Rekan rekan;

    Pemain(String nama, int health) { 
        this.nama = nama; 
        this.health = health; 
    }

    void setSenjata(Senjata s) {
        this.senjata = s; 
    }

    void setRekan(Rekan r) { 
        this.rekan = r; 
    }

    void serangZombie(Zombie z) {
        if (senjata != null) {
            System.out.println(nama + " serang zombie (" + senjata.damage + ")");
            z.health -= senjata.damage;
            if (z.health <= 0) System.out.println("Zombie kalah!");
        } else System.out.println(nama + " tak bersenjata!");
    }
    
    void terimaDamage(int d) {
        this.health -= d;
        System.out.println(nama + " terima " + d + " damage. Health: " + health);
        if (health <= 0) System.out.println(nama + " kalah!");
    }
    void info() {
        System.out.println("Pemain: " + nama + " (" + health + ")");
        senjata.info();
        rekan.info();
    }
}

public class Game {
    public static void main(String[] args) {
        Pemain adi = new Pemain("adi", 100);
        Senjata shotgun = new Senjata("Shotgun", 85);
        Rekan caca = new Rekan("caca", "Healing");
        Zombie z1 = new Zombie();

        System.out.println("=== Deadtrails ===");
        adi.setSenjata(shotgun);
        adi.setRekan(caca);
        adi.info();
        caca.bantuPemain(adi);
        System.out.println("kesehatan adi: " +" adi.health);


        System.out.println("\n--- Akhir ---");
        caca.info();
        System.out.println("Zombie Health: " + z1.health);
    }
}