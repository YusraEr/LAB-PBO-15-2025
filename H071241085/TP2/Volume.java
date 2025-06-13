package TP2;

class Cuboid{
    double height;
    double widht;
    double length;

    double getVolume(){
        //Lengkapi:
        return height * widht * length;
    }
}

public class Volume {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();
        //Lengkapi
        cuboid.height = 30;
        cuboid.length = 15;
        cuboid.widht = 10;
        System.out.printf("Volume = %2.f", cuboid.getVolume());
    }
}
