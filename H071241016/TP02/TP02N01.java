public class TP02N01 {
    String name;
    int age;
    boolean isMale;
    int height;

    // Method untuk mengatur nilai atribut name
    public void setName(String name) {
        this.name = name;
    }

    // Method untuk mendapatkan nilai atribut name
    public String getName() {
        return name;
    }

    // Method untuk mengatur nilai atribut age
    public  void setAge(int age) {
        this.age = age;
    }

    // Method untuk mendapatkan nilai atribut age
    public int getAge() {
        return age;
    }

    // Method untuk mengatur nilai atribut jenis kelamin
    public void setGender(boolean isMale) {
        this.isMale = isMale;
    }

    // Method untuk mendapatkan nilai atribut isMale (jenis kelamin) dalam bentuk string
    public String getGender() {
        if (isMale == true) {
            return "Laki-laki";
        } else {
            return "Perempuan";
        }
    }

    public int height() {
        return height;
    }

    // Method utama (main) untuk menjalankan program
    public static void main(String[] args) {
        // Membuat objek TP02N01 baru
        TP02N01 person = new TP02N01();

        // Mengatur nilai atribut-atribut objek person menggunakan metode setter
        person.setName("Adi Baratha Nv");
        person.setAge(19);
        person.setGender(true); // true berarti laki-laki
        person.height = 170;


        // Menampilkan informasi orang menggunakan metode getter
        System.out.println("Nama: " + person.getName());
        System.out.println("Umur: " + person.getAge());
        System.out.println("Jenis Kelamin: " + person.getGender());
        System.out.println("tinggi: " + person.height);
    }
}