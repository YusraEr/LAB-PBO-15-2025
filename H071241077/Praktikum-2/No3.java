class Cuboid {
    double height;
    double width;
    double length;

    public void SetHeight (double height) {
        this.height = height;
    }

    double getVolume() {
        return height * width * length;
    }
}

public class No3 {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();
         
        cuboid.SetHeight(10);
        cuboid.width = 15;   
        cuboid.length = 30;  
        System.out.printf("Volume = %.2f%n", cuboid.getVolume());
    }
}