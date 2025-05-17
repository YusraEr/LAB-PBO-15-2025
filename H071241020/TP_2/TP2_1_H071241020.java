package TP_2;

public class TP2_1_H071241020 {
    private String name;
    private int age;
    private boolean isMale;

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

    public void setGender(boolean isMale) {
        this.isMale = isMale;
    }

    public String getGender() {
        return isMale ? "Male" : "Female";
    }

    public static void main(String[] args) {
        TP2_1_H071241020 person = new TP2_1_H071241020();
        
        person.setName("John Doe");
        person.setAge(25);
        person.setGender(true);
        person.age=30;
        System.out.println("Name: " + person.name);
        System.out.println("Age: " + person.getAge());
        System.out.println("Gender: " + person.getGender());
    }
}