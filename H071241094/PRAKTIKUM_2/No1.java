public class No1 {
    String name;
    int age;
    boolean isFemale;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setGender(boolean isFemale) {
        this.isFemale = isFemale;
    }

    public String getGender() {
        return isFemale ? "Perempuan" : "Laki-laki";
    }

    public static void main(String[] args) {

        No1 person1 = new No1();

        person1.setName("Angel");
        person1.setAge(19);
        person1.setGender(true);

        person1.isFemale = false;

        System.out.println("Nama: " + person1.getName());
        System.out.println("Usia: " + person1.age);
        System.out.println("Jenis Kelamin: " + person1.isFemale);
    }
}
