package TP3;

import java.util.Random;

public class Game {
    private Random random = new Random();

    public void mulaiPertarungan(Hero hero1, Hero hero2, Skill skill1, Skill skill2) {
        System.out.println("=== MOBILE LEGENDS CUSTOM MODE: " + hero1.nama + " VS " + hero2.nama + " ===");

        while (hero1.masihHidup() && hero2.masihHidup()) {
            System.out.println("\n--- GILIRAN " + hero1.nama.toUpperCase() + " ---");

            boolean pilihComboHero1 = random.nextBoolean();
            hero1.skill = pilihComboHero1 ? skill1 : skill2;
            hero1.gunakanSkill(hero2);

            if (!hero2.masihHidup()) {
                System.out.println(hero2.nama + " kalah! " + hero1.nama.toUpperCase() + " MENANG!");
                break;
            }

            System.out.println("\n--- GILIRAN " + hero2.nama.toUpperCase() + " ---");

            boolean pilihComboHero2 = random.nextBoolean();
            hero2.skill = pilihComboHero2 ? skill1 : skill2;
            hero2.gunakanSkill(hero1);

            if (!hero1.masihHidup()) {
                System.out.println(hero1.nama + " kalah! " + hero2.nama.toUpperCase() + " MENANG!");
                break;
            }

            System.out.println("\n--- STATUS SAAT INI ---");
            hero1.tampilkanStatus();
            hero2.tampilkanStatus();
        }

        System.out.println("\n=== GAME SELESAI ===");
    }
}
