package dinooo;

public class Person {
    String personName;
    String personJob;
    int personAge;

    public Person(String personName, String personJob, int personAge){
        this.personName = personName;
        this.personJob = personJob;
        this.personAge = personAge;

    }

    public void setPersonName(String newPersonName){this.personName = newPersonName;}
    public void setPersonJob(String newPersonJob){this.personJob = newPersonJob;}
    public void setPersonAge(int newPersonAge){this.personAge = newPersonAge;}

    public String getPersonName(){return this.personName;}
    public String getPersonJob(){return this.personJob;}
    public int getPersonAge(){return this.personAge;}

    public void displayInfo(){
        Person person = new Person(personName, personJob, personAge);
        person.setPersonName("ivan");
        person.setPersonJob("consultant");
        person.setPersonAge(20);
    }
}
