package dinooo;

public class Dinosaurus {
    public String dinosaurusName;
    public int dinosaurusLegs;
    public int hp = 100;
    public boolean isMoving;
    public boolean isAttacking;
    public int attackPower;

    //membuat constructor
    public Dinosaurus(
        String dinosaurusName, 
        int dinosaurusLegs, 
        int hp, 
        boolean isMoving,
        boolean isAttacking,
        int attackPower)
        
        {
        this.dinosaurusName = dinosaurusName;
        this.dinosaurusLegs = dinosaurusLegs;
        this.hp = hp;
        this.isMoving = isMoving;
        this.isAttacking = isAttacking;
        this.attackPower = attackPower;
    }

    //membuat fungsi setter dan getter
    public void setDinosaurusName(String newDinosaurusName)     {this.dinosaurusName = newDinosaurusName;}
    public void setDinosauruslegs(int newDinosaurusLegs)        {this.dinosaurusLegs = newDinosaurusLegs;}
    // public void setHp(int newHp)                                {this.hp = newHp;}
    public void setIsMoving(boolean newIsMoving)                {this.isMoving = newIsMoving;} 
    public void setIsAttacking(boolean newIsAttacking)          {this.isAttacking = newIsAttacking;}
    public void setAttackPower(int newAttackPower)              {this.attackPower = newAttackPower;}


    public String getDinosaurusName()   {return this.dinosaurusName;}
    public int getDinosaurusLegs()      {return this.dinosaurusLegs;}
    // public int getHp()                  {return this.hp;}
    public boolean getIsMoving()        {return this.isMoving;}
    public boolean getIsAttacking()     {return this.isAttacking;}
    public int getAttackPower()         {return this.attackPower;}
    
    public void attack(Dinosaurus enemy){
        enemy.hp -= this.attackPower;
    }
    
    public void displayInfo(){
        System.out.println("dinosaurus name: "+ dinosaurusName);
        System.out.println("dinosaurus legs: "+ dinosaurusLegs);

        if (isMoving == true){
            System.out.println("moving status: is moving");
        }else{
            System.out.println("moving status: is not moving");
        }
    }
}


