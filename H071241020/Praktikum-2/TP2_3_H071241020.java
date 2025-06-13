package TP_2;

class Cuboid {
    double height;
    double width;
    double length;

    double getVolume() {
        return height * width * length;
    }
}

public class TP2_3_H071241020 {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();
        
        cuboid.height = 15.0;
        cuboid.width = 20.0;
        cuboid.length = 15.0;
        
        System.out.printf("Volume = %.2f", cuboid.getVolume());
    }
}