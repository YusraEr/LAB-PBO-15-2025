package plane;


abstract class Plane {
    protected String nama;

    Plane (String nama) {
        this.nama = nama;
    }

    abstract String getPlaneName();

    public void display(){
        System.out.println("this plane is " + nama);
    }

}
