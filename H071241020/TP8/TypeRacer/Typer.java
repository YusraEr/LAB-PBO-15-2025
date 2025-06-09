package TP8.TypeRacer;

class Typer extends Thread {
    private String botName, wordsTyped;
    private double wpm;
    private TypeRacer typeRacer;

    public Typer(String botName, double wpm, TypeRacer typeRacer) {
        this.botName = botName;
        this.wpm = wpm;
        this.wordsTyped = "";
        this.typeRacer = typeRacer;
    }

    public void setBotName(String botName) {
        this.botName = botName;
    }

    public void setWpm(double wpm) {
        this.wpm = wpm;
    }

    public void addWordsTyped(String newWordsTyped) {
        this.wordsTyped += newWordsTyped + " ";
    }

    public String getWordsTyped() {
        return wordsTyped;
    }

    public String getBotName() {
        return botName;
    }

    public double getWpm() {
        return wpm;
    }

    @Override
    public void run() {
        String[] wordsToType = typeRacer.getWordsToType().split(" ");
        
        // TODO (1)
        double timePerWordInSeconds = 60.0 / wpm;

        long startTime = System.currentTimeMillis();

        try {
            // TODO (2)
            for (String word : wordsToType) {
                Thread.sleep((long)(timePerWordInSeconds * 1000));
                addWordsTyped(word);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.addWordsTyped("(Selesai)");

        long finishTime = (System.currentTimeMillis() - startTime) / 1000;

        // TODO (3)
        typeRacer.addResult(new Result(botName, (int)finishTime));
    }
}
