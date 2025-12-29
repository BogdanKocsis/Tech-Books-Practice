package main;

import config.ProjectConfig;
import model.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot parrot = context.getBean("miki", Parrot.class);
        System.out.println(parrot.getName());

    }
}
