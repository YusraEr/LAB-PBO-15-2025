package TypeRacer;

import java.util.ArrayList;
import java.util.Random;

public class TypeRacer {
    private String wordsToType;
    private ArrayList<Typer> rareContestant = new ArrayList<>();
    private ArrayList<Result> rareStanding = new ArrayList<>();

    public String getWordsToType() {
        return wordsToType;
    }

    public ArrayList<Typer> getRareContestant() {
        return rareContestant;
    }

    // Bisa diganti sesuai keinginan masing-masing
    private String[] wordsToTypeList = {
            "Gadis koleris yang suka berimajinasi, terangi harimu dengan senyuman keramelku. Hai, aku Freya!",
            "Si gadis tomboy yang semangatnya meletup letup, Hai aku Zee!",
            "Seperti pizza yang selalu dinanti-nantikan orang, selalu nantikan aku yaa! Halo, aku Marsha!",
            "Peduli dan berbaik hati, siapakah dia? chris... ty.. chris... ty.. chris... ty..",
            "Semanis coklat, selembut sutra. Halo, aku Shani!"
    };

    public void setNewWordsToType() {
        Random random = new Random();
        int angkaRandom = random.nextInt(wordsToTypeList.length);
        wordsToType = wordsToTypeList[angkaRandom];
    }

    // TODO (4)
    // Buat method addResult yang mana digunakan untuk menambahkan typer yang
    // telah selesai (mengetik semua kata), ke dalam list race standing.
    public synchronized void addResult(String name, int finishTime) {
        rareStanding.add(new Result(name, finishTime));
    }

    private void printRaceStanding() {
        System.out.println("\nKlasemen Akhir Type Racer");
        System.out.println("=========================\n");

        // TODO (5)
        // Tampilkan klasemen akhir dari kompetisi, dengan format
        // {posisi}. {nama} = {waktu penyelesaian dalam detik} detik
        for (int i = 0; i < rareStanding.size(); i++) {
            Result result = rareStanding.get(i);
            System.out.printf("%d. %s = %d detik\n", i + 1, result.getName(), result.getFinishTime());
        }
    }
    

    public void startRace() {
        // TODO (6)
        // Jalankan kompetisi untuk tiap kontestan
        for (Typer typer : rareContestant) {
            typer.start();
        }
    }

    // TODO (7)
    // selama semua peserta belum selesai maka tampilkan typing progress-nya setiap
    // 2 detik, dengan format:
    // Typing Progress ...
    // ===================
    // {nama kontestan} => {text yang telah dia ketik}
    // {nama kontestan} => {text yang telah dia ketik}
    // {nama kontestan} => {text yang telah dia ketik}
    public void displayRaceStandingPeriodically() throws InterruptedException {
        boolean allDone = false;
        Thread.sleep(1000);
        
        while (!allDone) {
            System.out.println("\nTyping Progress ...");
            System.out.println("===================");
            
            allDone = true;
            for (Typer typer : rareContestant) {
                System.out.printf("%s => %s\n", typer.getBotName(), typer.getWordsTyped());
                if (typer.isAlive()) allDone = false;
            }
            
            if (!allDone) Thread.sleep(2000);
        }
        
        // TODO (8)
        // Setelah semua typer selesai, tampilkan race standing setelah semua typer
        // selesai
        printRaceStanding();
    }
}
