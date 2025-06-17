package TP3;


public class Skill {
    public String namaSkill;
    public int damage;

    public Skill() {
        this.namaSkill = "Skill Default";
        this.damage = 10;
    }

    public Skill(String namaSkill, int damage) {
        this.namaSkill = namaSkill;
        this.damage = damage;
    }
}