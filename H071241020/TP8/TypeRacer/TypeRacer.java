package TP8.TypeRacer;

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

    public synchronized void addResult(Result result) {
        rareStanding.add(result);
    }

    private void printRaceStanding() {
        System.out.println("\nKlasemen Akhir Type Racer");
        System.out.println("=========================\n");

        rareStanding.sort((a, b) -> Integer.compare(a.getFinishTime(), b.getFinishTime()));

        int posisi = 1;
        for (Result result : rareStanding) {
            System.out.println(posisi + ". " + result.getName() + " = " + result.getFinishTime() + " detik");
            posisi++;
        }
    }

    public void startRace() {
        for (Typer typer : rareContestant) {
            typer.start();
        }
    }

    public void displayRaceStandingPeriodically() throws InterruptedException {
        while (true) {
            System.out.println("\nTyping Progress ...");
            System.out.println("===================");

            for (Typer typer : rareContestant) {
                System.out.println(typer.getBotName() + " => " + typer.getWordsTyped());
            }

            // Periksa apakah semua thread selesai
            boolean allFinished = true;
            for (Typer typer : rareContestant) {
                if (typer.isAlive()) {
                    allFinished = false;
                    break;
                }
            }

            if (allFinished) {
                break;
            }

            Thread.sleep(2000);
        }

        // Tunggu semua thread selesai (join)
        for (Typer typer : rareContestant) {
            typer.join();  // memastikan semua benar-benar selesai
        }

        printRaceStanding();
    }
}

