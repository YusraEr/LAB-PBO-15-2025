package leagueOfHero;

public class Hero {
    String name;
    int health;
    int attackPower;
    

    public Hero(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public void attack(){
        System.out.println(name + " menyerang dengan kekuatan " + attackPower + "\n");
    }
}
