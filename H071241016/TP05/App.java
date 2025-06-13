import human.Human;
import plane.Rectangle;

public class App {
    public static void main(String[] args) throws Exception {
        Rectangle segiEmpat = new Rectangle( "Segi Empat");
        System.out.println(segiEmpat.getPlaneName());
        segiEmpat.display();

        Human manusia = new Human ("caca");
        manusia.describable();
        manusia.breathing();
    }
    
}
