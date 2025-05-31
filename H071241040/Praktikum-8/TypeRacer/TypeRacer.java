package TypeRacer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
            "Di Bikini Bottom ada Spongebob Squarepants, dia memang keren suka main drumband",
            "Dia jadi koki masaknya krabby patty, menjalani hari hidup bersama Garry",
            "Ayo sama-sama sebutkan nama-nama makhluk dalam sana di Bikini Bottom jaya",
            "Namun ada juga namanya Patrick Star, walau dia cetar tapi hidupnya liar",
            "Tinggal dalam batu tapi suka membantu, sayang hanya satu otaknya itu buntu"
    };

    public void setNewWordsToType() {
        Random random = new Random();
        int angkaRandom = random.nextInt(wordsToTypeList.length);
        wordsToType = wordsToTypeList[angkaRandom];
    }

    // TODO (4)
    // Buat method addResult yang mana digunakan untuk menambahkan typer yang
    // telah selesai (mengetik semua kata), ke dalam list race standing.

    public synchronized void addResult(Result result) {
        rareStanding.add(result);
    }

    private void printRaceStanding() {
        Collections.sort(rareStanding, Comparator.comparingInt(Result::getFinishTime));
        System.out.println("\nKlasemen Akhir Type Racer");
        System.out.println("=========================\n");

        int posisi = 1;
        for (Result result : rareStanding) {
            System.out.println(posisi + ". " + result.getName() + " = " + result.getFinishTime() + " detik");
            posisi += 1;
        }

        System.out.println("\n=========================");
    }



    // TODO (6)
    // Jalankan kompetisi untuk tiap kontestan

    public void startRace() throws InterruptedException {
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

        boolean raceFinished = false;

        while (!raceFinished) {
            System.out.println("\nTyping Progress ...");
            System.out.println("===================");
            for (Typer t : rareContestant) {
                System.out.println(t.getBotName() + " => " + t.getWordsTyped());
            }
            Thread.sleep(2000);


            raceFinished = true;
            for (Typer t : rareContestant) {
                if (t.isAlive()) {
                    raceFinished = false;
//                    for (Typer c : rareContestant) {
//                        System.out.println(c.getBotName() + " => " + c.getWordsTyped());
//                    }
                    break;
                }
            }
        }
        System.out.println("\nTyping Progress ...");
        System.out.println("===================");
        for (Typer t : rareContestant) {
            System.out.println(t.getBotName() + " => " + t.getWordsTyped());
        }
        // TODO (8)
        // Setelah semua typer selesai, tampilkan race standing setelah semua typer
        // selesai
        printRaceStanding();
    }
}

