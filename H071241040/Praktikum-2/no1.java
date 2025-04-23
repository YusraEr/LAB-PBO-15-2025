class Person{
    String name;
    int age;
    boolean isMale;

    int getAge() {
        return age;
    }
    void setAge(int age) {
        this.age = age;
    }
    String getName() {
        return name;
    }
    void setName(String name) {
        this.name = name;
    }

    void setGender(boolean isMale) {
        this.isMale = isMale;
    }
    String getGender(){
        if (isMale){
            return "Male";
        }else{
            return "Female";
        }
    }
}


public class no1 {
    public static void main(String[] args) {
        Person orang = new Person();

        orang.setName("Badarui");
        orang.name = "caca";
        orang.setAge(25);
        orang.setGender(false);

        System.out.println("Nama : " + orang.getName());
        System.out.println("Umur : "+ orang.getAge());
        
        if(orang.getGender() == "Male"){
            System.out.println("Ras: Walid");
        }else{
            System.out.println("Ras: Dewi");
        }
    }
} 
    
