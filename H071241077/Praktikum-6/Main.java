public class Main {
    public static void main(String[] args) {
        SkuterListrik skuterlistrik = new SkuterListrik("Honda", "Astrea");
        skuterlistrik.setKapasitasMuatan(40);
        skuterlistrik.setKecepatan(20);
        skuterlistrik.hitungPajak();

        skuterlistrik.mulai();
        System.out.println("Merek: " + skuterlistrik.getMerek());
        System.out.println("Model: " + skuterlistrik.getModel());
        System.out.println("Kapasitas Muatan: " + skuterlistrik.getKapasitasMuatan());
        System.out.println("Kecepatan: " + skuterlistrik.getKecepatan());
        System.out.println("Hitung Pajak: " + skuterlistrik.hitungPajak());

        skuterlistrik.berhenti();

        

    }
}


