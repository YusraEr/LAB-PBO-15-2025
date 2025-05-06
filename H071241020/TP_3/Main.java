public class Main {
    public static void main(String[] args) {
        Skill combo1 = new Skill("Jeet Kune Do", 25);
        Skill combo2 = new Skill("The Way of Dragon", 40);

        Hero chou = new Hero("Chou", 100, combo1);
        Hero musuh = new Hero("Musuh", 100, combo1);

        Game game = new Game();
        game.mulaiPertarungan(chou, musuh, combo1, combo2);
    }
}
