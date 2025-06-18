package sctp4;

public class BaksoMercon {
    private String nama;
    private  int id;

    public BaksoMercon(String nama, int id){
        this.nama = nama;
        this.id = id;
    }

    public String getNama(){
        return nama;
    }

    public int getId(){
        if(id > 0);
            return id;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public static void naikPangkat(int id, int jumlah){
        jumlah --;
        System.out.println("Lah jadi Intel, karyawan tersisa: " + jumlah);
    }
}
