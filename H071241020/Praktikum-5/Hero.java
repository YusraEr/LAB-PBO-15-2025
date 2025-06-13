package TP5;
public class Hero {
    protected String name;
    protected int health;
    protected int attackPower;

    public Hero(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public void serang() {
        System.out.println(name + " menyerang dengan kekuatan " + attackPower);
    }
}
