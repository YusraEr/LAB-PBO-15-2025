public class mahasiswa {
    String nama;
    String nim;
    boolean terisi = false;
    gradeReport grade = new gradeReport();

    public mahasiswa() {
        this.nama = "Default";
        this.nim = "0";
    }
    public mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }
    public boolean getSukses(){
        return terisi;
    }
    public void setSukses(){
        this.terisi = true;
    }

    public void setName(String nama) {
        this.nama = nama;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public gradeReport getGrade() {
        return grade;
    }

    public void tampilkanInfo() {
        System.out.println("\n--- Info Mahasiswa ---");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Nilai: " + grade.getNilai());
        System.out.println("Status: " + grade.getKelulusan());
        grade.getRincian();
        System.out.println("------------------------\n");
    }

    public void bandingkanNilai(mahasiswa other) {
        double nilaiSaya = this.getGrade().getNilai();
        double nilaiLain = other.getGrade().getNilai();

        System.out.println("Perbandingan Nilai:");
        System.out.println(this.nama + " (" + nilaiSaya + ") vs " + other.nama + " (" + nilaiLain + ")");
        if (nilaiSaya > nilaiLain) {
            System.out.println(this.nama + " memiliki nilai lebih tinggi.");
        } else if (nilaiSaya < nilaiLain) {
            System.out.println(other.nama + " memiliki nilai lebih tinggi.");
        } else {
            System.out.println("Keduanya memiliki nilai yang sama.");
        }
    }
}
