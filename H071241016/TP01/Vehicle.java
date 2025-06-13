public class Vehicle {
    String type;
    String brand;
    String name;
    String color;
    int wheels;
    Boolean isElectric;


    public static void main(String[] args) {
        Vehicle car = new Vehicle();
        car.type = "Sedan";
        car.brand = "BMW";
        car.name = "M3";
        car.color = "pink";
        car.wheels = 4;
        car.isElectric = true;

        System.out.println("Vehicle Type: " + car.type);
        System.out.println("Vehicle Brand: " + car.brand);
        System.out.println("Vehicle Name: " + car.name);
        System.out.println("Vehicle  Color: " + car.color);
        System.out.println("Vehicle  Wheels: " + car.wheels);
        if (car.isElectric == true) {
            System.out.println("Vehicle status : electric vehicle");
        } else {
            System.out.println("Vehicle status : non electric vehicle");
        }

        

    }   


}
