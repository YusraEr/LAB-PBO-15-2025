
public class Main {
    public static void main(String[] args) {

  
Truk truk = new Truk("simpel", "series");
truk.setKapasitasMuatan(10); 
truk.setKecepatan(60.0);
    
System.out.println("Merk: " + truk.merk);
System.out.println("Model: " + truk.model);
System.out.println("Kapasitas Muatan: " + truk.getKapasitasMuatan() + " ton");
System.out.println("Kecepatan: " + truk.getKecepatan() + " km/h");
System.out.println(".(Truk Mulai):" + truk.mulai());
System.out.println(".(Truk Mulai):" + truk.berhenti());
System.out.println();
}
}