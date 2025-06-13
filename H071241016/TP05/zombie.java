// Kelas AgenBSAA
class AgenBSAA {
    private String nama;
    private String spesialisasi;
    private int stamina;
    private boolean terinfeksiCVirus;
    private Partner agenPartner; // Objek dari class AgenBSAA (self-referencing)
    private SenjataRE senjataUtama; // Objek dari class Senjata
    private LokasiRE misiSaatIni; // Objek dari class Lokasi

    // Constructor default
    public AgenBSAA() {
    }

    // Constructor dengan parameter minimal
    public AgenBSAA(String nama, String spesialisasi) {
        this.nama = nama;
        this.spesialisasi = spesialisasi;
        this.stamina = 100;
        this.terinfeksiCVirus = false;
    }

    // Getter dan Setter
    public String getNama() { 
        return nama; 
    }

    public void setNama(String nama) {
        this.nama = nama; 
    }

    public String getSpesialisasi() { 
        return spesialisasi; 
    }

    public void setSpesialisasi(String spesialisasi) { 
        this.spesialisasi = spesialisasi; 
    }

    public int getStamina() { 
        return stamina; 
    }
    public void setStamina(int stamina) { this.stamina = stamina; }
    public void isTerinfeksiCVirus() { 
        if ( terinfeksiCVirus == true){
            System.out.println( nama + "telah digigit dan terinfeksi");
        }
        else {
            System.out.println("agen belum digigit dan tidak terinfeksi");
        }
    }

    public void setTerinfeksiCVirus(boolean terinfeksiCVirus) { this.terinfeksiCVirus = terinfeksiCVirus; }
    public Partner getAgenPartner() { return agenPartner; }
    public void setAgenPartner(Partner agenPartner) { this.agenPartner = agenPartner; }
    public SenjataRE getSenjataUtama() { return senjataUtama; }
    public void setSenjataUtama(SenjataRE senjataUtama) { this.senjataUtama = senjataUtama; }
    public LokasiRE getMisiSaatIni() { return misiSaatIni; }
    public void setMisiSaatIni(LokasiRE misiSaatIni) { this.misiSaatIni = misiSaatIni; }

    // Method bekerjaSama(AgenBSAA rekan) - Interaksi antar objek class yang sama
    public void bekerjaSama(AgenBSAA rekan) {
        if (rekan != null && rekan != this) {
            System.out.println(this.nama + " bekerja sama dengan " + rekan.nama + " dalam misi di " + (misiSaatIni != null ? misiSaatIni.getNama() : "lokasi yang tidak diketahui") + ".");
            this.agenPartner = new Partner(rekan.nama, rekan.spesialisasi); // Menggunakan class Partner
            rekan.agenPartner = new Partner(this.nama, this.spesialisasi); // Menggunakan class Partner
        } else if (rekan == this) {
            System.out.println(this.nama + " tidak bisa bekerja sama dengan dirinya sendiri.");
        } else {
            System.out.println(this.nama + " tidak dapat bekerja sama dengan rekan yang tidak ada.");
        }
    }

    // Method menggunakanSenjata(BioWeapon target) - Interaksi dengan atribut objek (senjataUtama)
    public void menggunakanSenjata(BioWeapon target) {
        if (senjataUtama != null && target != null && stamina > 0) {
            System.out.println(this.nama + " menggunakan " + senjataUtama.getNama() + " untuk menyerang " + target.getNama() + ".");
            target.terimaSerangan(senjataUtama.getDamage());
            this.stamina -= 10; // Contoh pengurangan stamina
            if (stamina < 0) stamina = 0;
        } else if (stamina <= 0) {
            System.out.println(this.nama + " kehabisan stamina dan tidak bisa menyerang.");
        } else if (senjataUtama == null) {
            System.out.println(this.nama + " tidak memiliki senjata untuk menyerang.");
        } else {
            System.out.println(this.nama + " tidak dapat menyerang target yang tidak ada.");
        }
    }

    public static void main(String[] args) {
        AgenBSAA leon = new AgenBSAA("Leon S. Kennedy", "Ahli Senjata");
        AgenBSAA helena = new AgenBSAA("Helena Harper", "Penembak Jitu");
        BioWeapon ogroman = new BioWeapon("Ogroman", "B.O.W. Besar", 150);
        SenjataRE wingShooter = new SenjataRE("Wing Shooter", "Handgun", 25);
        LokasiRE tallOaks = new LokasiRE("Tall Oaks University", "Malam");
        leon.setTerinfeksiCVirus(true);

        leon.setSenjataUtama(wingShooter); 
        leon.setMisiSaatIni(tallOaks);
        helena.setMisiSaatIni(tallOaks);

        leon.bekerjaSama(helena);
        leon.menggunakanSenjata(ogroman);
        helena.menggunakanSenjata( ogroman); 

        System.out.println("\nStatus Agen:");
        System.out.println(leon.getNama() + " - Stamina: 0 " + ", Partner: " + (leon.getAgenPartner() != null ? leon.getAgenPartner().getNama() : "Tidak ada"));
        System.out.println(helena.getNama() + " - Stamina: " + helena.getStamina() + ", Partner: " + (helena.getAgenPartner() != null ? helena.getAgenPartner().getNama() : "Tidak ada"));
        System.out.println("\nStatus Bio-Weapon:");
        System.out.println(ogroman.getNama() + " - Kesehatan: " + ogroman.getKesehatan());

        System.out.println("\nagen terinfeksi CVirus:");
        leon.isTerinfeksiCVirus();
        System.out.println(helena.getNama() + " tidak terinfeksi dengan virus" );


    }
}

// Class Partner (Merepresentasikan partner agen, bukan turunan AgenBSAA)
class Partner {
    private String nama;
    private String spesialisasi;

    public Partner(String nama, String spesialisasi) {
        this.nama = nama;
        this.spesialisasi = spesialisasi;
    }

    public String getNama() { return nama; }
    public String getSpesialisasi() { return spesialisasi; }
}

// Kelas SenjataRE (RE untuk Resident Evil)
class SenjataRE {
    private String nama;
    private String jenis;
    private int damage;

    public SenjataRE(String nama, String jenis, int damage) {
        this.nama = nama;
        this.jenis = jenis;
        this.damage = damage;
    }

    public String getNama() { return nama; }
    public int getDamage() { return damage; }
}

// Kelas BioWeapon
class BioWeapon {
    private String nama;
    private String jenis;
    private int kesehatan;

    public BioWeapon(String nama, String jenis, int kesehatan) {
        this.nama = nama;
        this.jenis = jenis;
        this.kesehatan = kesehatan;
    }

    public String getNama() { return nama; }
    public int getKesehatan() { return kesehatan; }

    public void terimaSerangan(int damage) {
        this.kesehatan -= damage;
        if (this.kesehatan < 0) this.kesehatan = 0;
        System.out.println(this.nama + " menerima " + damage + " damage. Sisa kesehatan: " + this.kesehatan);
        if (this.kesehatan <= 0) {
            System.out.println(this.nama + " telah dikalahkan.");
        }
    }
}

// Kelas LokasiRE
class LokasiRE {
    private String nama;
    private String kondisi; // Contoh: Hancur, Aman, Terinfeksi

    public LokasiRE(String nama, String kondisi) {
        this.nama = nama;
        this.kondisi = kondisi;
    }

    public String getNama() { return nama; }
}