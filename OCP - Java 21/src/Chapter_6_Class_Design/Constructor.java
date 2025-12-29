package Chapter_6_Class_Design;

public class Constructor extends Animal {
    int age;
    String tests;

    //a Class can have multiple constructors, as long as each constructor has a unique constructor signature
    /* we need declaring multiple constructors with different signatures */ /**  Constructor overloading  */

    public Constructor(int age) {
        this.age = age;
    }

    public Constructor(String tests) {
        this.tests = tests;
    }


    // the default constructor has an empty parameter list and an empty body.

    // super is used to reference members of the parent class
    // super() calls a parent constructor

    // Constructors are used when creating a new object. This process is called instantiation because it creates
    // a new instance od the class. A constructor is called when we write new followed by the name pf the class
    // we want to instantiate.

    public static void main(String[] args){
        Constructor constructor = new Constructor(15);
        Constructor constructor1 = new Constructor("test");
        System.out.println(constructor.age);
        System.out.println(constructor1.tests);
    }

}
