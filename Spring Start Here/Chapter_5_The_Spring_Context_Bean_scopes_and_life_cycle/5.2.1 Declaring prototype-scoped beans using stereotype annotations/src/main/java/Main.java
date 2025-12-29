import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;
import services.UserService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        CommentService service1 = context.getBean(CommentService.class);
        UserService service2 = context.getBean(UserService.class);

        boolean b = service1.getCommentRepository() == service2.getCommentRepository();
        System.out.println("Are both repositories the same? " + b);
    }
}
