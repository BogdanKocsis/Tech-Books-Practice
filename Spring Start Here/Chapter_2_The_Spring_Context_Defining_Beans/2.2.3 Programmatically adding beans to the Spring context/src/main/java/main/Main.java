package main;

import config.ProjectConfig;
import model.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot parrot = new Parrot();
        parrot.setName("Polly");

        Supplier<Parrot> parrotSupplier = () -> parrot;

        context.registerBean("parrotBean", Parrot.class, parrotSupplier, bc -> bc.setPrimary(true));

        Parrot parrotBean = context.getBean("parrotBean", Parrot.class);
        System.out.println("Parrot's name: " + parrotBean.getName());
    }
}
