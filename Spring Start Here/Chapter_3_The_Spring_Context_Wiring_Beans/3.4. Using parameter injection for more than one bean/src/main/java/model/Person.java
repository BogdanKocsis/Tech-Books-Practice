package model;

public class Person {
    private String name = "Ella";


    private Parrot parrot;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getParrot() {
        return this.parrot.getName();
    }

    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }

}