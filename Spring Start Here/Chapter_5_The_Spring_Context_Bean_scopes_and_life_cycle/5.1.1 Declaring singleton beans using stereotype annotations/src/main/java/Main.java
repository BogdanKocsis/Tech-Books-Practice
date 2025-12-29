import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;
import services.UserService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        CommentService commentService = context.getBean(CommentService.class);
        UserService userService = context.getBean(UserService.class);
        boolean b = commentService.getCommentRepository() == userService.getCommentRepository();
        System.out.println("Are both repositories the same? " + b);

    }
}
