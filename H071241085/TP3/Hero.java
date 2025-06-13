package TP3;

public class Hero {
    public String nama;
    public int hp;
    public Skill skill; 

    public Hero() {
        this.nama = "Tanpa Nama";
        this.hp = 100;
        this.skill = new Skill();
    }

    public Hero(String nama, int hp, Skill skill) {
        this.nama = nama;
        this.hp = hp;
        this.skill = skill;
    }

    public void gunakanSkill(Hero musuh) {
        System.out.println(this.nama + " menggunakan " + this.skill.namaSkill + "!");
        musuh.hp -= this.skill.damage;
        if (musuh.hp < 0) musuh.hp = 0;
        System.out.println(musuh.nama + " kehilangan " + this.skill.damage + " HP!");
    }

    public void tampilkanStatus() {
        System.out.println(nama + " - HP: " + hp);
    }

    public boolean masihHidup() {
        return hp > 0;
    }
}
