public class Mahasiswa {
    String name;
    Double ipk;
    String nim;
    int tahunmasuk;
    String jurusan;
    String fakultas;
    String[] matkul;

    public static void main(String[] args) {
        Mahasiswa mahasiswa1 = new Mahasiswa();
        mahasiswa1.name = "Adi Baratha";
        mahasiswa1.ipk = 3.5;
        mahasiswa1.nim = "H071251016";
        mahasiswa1.tahunmasuk = 2025;
        mahasiswa1.jurusan = "Sistem informasi";
        mahasiswa1.fakultas = "MIPA";
        mahasiswa1.matkul = new String[]{"OOP", "Algoritma dan Struktur Data", "Pemrograman Web"};

        System.out.println("Nama: " + mahasiswa1.name); 
        System.out.println("IPK: " + mahasiswa1.ipk);
        System.out.println("NIM: " + mahasiswa1.nim);
        System.out.println("Tahun Masuk: " + mahasiswa1.tahunmasuk);
        System.out.println("Jurusan: " + mahasiswa1.jurusan);
        System.out.println("Fakultas: " + mahasiswa1.fakultas);
        System.out.println("List Mata Kuliah:");

        for (int i = 0; i < mahasiswa1.matkul.length; i++) {
            System.out.println("- " + mahasiswa1.matkul[i]);
        }



    }
}
    