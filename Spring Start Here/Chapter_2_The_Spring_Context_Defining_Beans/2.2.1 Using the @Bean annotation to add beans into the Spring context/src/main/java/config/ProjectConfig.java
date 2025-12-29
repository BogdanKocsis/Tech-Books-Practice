package config;

import model.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    Parrot parrot() {
        Parrot parrot = new Parrot();
        parrot.setName("Bobo");
        return parrot;
    }

    @Bean
    String hello() {
        return "Hello, World!";
    }

    @Bean
    Integer number() {
        return 42;
    }
}
