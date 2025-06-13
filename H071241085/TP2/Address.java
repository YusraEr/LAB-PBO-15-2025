package TP2;

class Alamat{
    String jalan;
    String kota;

    public String toString(){
        return jalan + ", " + kota;
    }
}

class Mahasiswa{
    String nama;
    String nim;
    Alamat alamat;

    public String getNama()     {return nama;}
    public String getNim()      {return nim;}
    public String getAlamat()   {return alamat.toString();}
}

public class Address {
    public static void main(String[] args){
       Alamat alamat = new Alamat();
       Mahasiswa mahasiswa = new Mahasiswa();

       alamat.jalan     = "Jl. palapa V";
       alamat.kota      = "Makassar";
       mahasiswa.nama   = "Ivan Ramadhan";
       mahasiswa.nim    = "H071241085";
       mahasiswa.alamat = alamat;

       System.out.println("Nama : " + mahasiswa.nama);
       System.out.println("Nim : " + mahasiswa.nim);
       System.out.println("Alamat : " + mahasiswa.alamat);
    }   
}
