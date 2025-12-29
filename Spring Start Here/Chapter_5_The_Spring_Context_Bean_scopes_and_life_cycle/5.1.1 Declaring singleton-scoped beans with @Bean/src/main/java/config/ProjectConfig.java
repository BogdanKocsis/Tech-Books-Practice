package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import services.CommentService;

@Configuration
@ComponentScan(basePackages = {"repositories", "proxies"})
public class ProjectConfig {

    @Bean
    public CommentService commentService() {
        return new CommentService(null, null);
    }
}
