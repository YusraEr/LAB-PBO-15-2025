package TP2;

public class Nomor001 {
    String name;
	int age;
	Boolean isMale;

	public void setName(String name)		{ this.name = name;}
	public String getName()					{ return this.name;}

	public void setAge(int age)				{ this.age = age;}
	public int getAge()						{ return this.age;}

	public void setGender(Boolean isMale)	{ this.isMale = isMale;}
	public String getGender()				{ return this.isMale ? "Laki-laki" : "Perempuan";}

	public static void main(String[] args) {
		Nomor001 person = new Nomor001();
        person.setName("Ivan");
        person.setAge(20);
        person.setGender(true);
		person.name = "yusra";

        System.out.println("Name   : " + person.getName());
        System.out.println("Age    : " + person.getAge());
        System.out.println("Gender : " + person.getGender());
	}
}
