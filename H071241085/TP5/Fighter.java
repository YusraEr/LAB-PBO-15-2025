package leagueOfHero;

public class Fighter extends Hero{

    public Fighter(String name, int health, int attackPower){
        super(name, health, attackPower);
    }

    public void attackEnemy(){
        this.attack();
    }
        
}
