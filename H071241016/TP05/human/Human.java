package human;

public class Human implements Describable, Breathing{
    String name;

    public Human(String name){
        this.name = name;

    }

    public void describable(){
        System.out.println(name + "bisa dideskripsikan");
    }

    public void breathing(){
        System.out.println(name + "bisa bernafas");
    }
}
