package model;

public class Person {
    private String name;
    private Parrot parrot;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getParrot() {
        return parrot != null ? parrot.getName() : null;
    }

    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }
}
