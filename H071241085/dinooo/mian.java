package dinooo;

public class mian {

    public static void main(String[] args) {
        Dinosaurus dino1 = new Dinosaurus("trex", 2, 100, true, true, 20);
        Dinosaurus dino2 = new Dinosaurus("asep", 2, 100, true, true, 18);
        dino1.attack(dino2);
        dino2.attack(dino1);
        dino1.displayInfo();
        dino2.displayInfo();
    }
}