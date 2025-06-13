class Cuboid {
    // atribut kelas TP02N03
    double height; // Tinggi kuboid
    double width; // Lebar kuboid
    double length; // Panjang kuboid

    // method untuk menghitung volume kuboid
    double getVolume() {
        return height * width * length;
    }
}

public class cuboid {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();

        // Mengatur nilai atribut objek cuboid
        cuboid.height = 15;
        cuboid.width = 10;
        cuboid.length = 30;

        // Menampilkan volume kuboid ke layar dengan format 2 angka desimal
        System.out.printf("Volume: %.2f", cuboid.getVolume());
    }

}