package sctp4;
public class Karyawan {
    private String nama;
    private int id;
    private static int jumlah;

    public Karyawan(String nama, int id){
        this.nama = nama;
        this.id = id;
        jumlah ++;
    }

    public void jumlahKaryawan() {
        System.out.println("Karyawan sekarang berjumlah: " + jumlah);
        
    }
    

    public static void naikPangkat(){
        jumlah --;
        System.out.println("Lah jadi Intel, karyawan tersisa: " + jumlah);
    }

    public String getNama(){
        return nama;
    }

    public int getId(){
        if(id > 0);
            return id;
    }

    public static void main(String[] args) {
        Karyawan karyawan1 = new Karyawan("riki", 1);
        karyawan1.jumlahKaryawan();
    }
}

