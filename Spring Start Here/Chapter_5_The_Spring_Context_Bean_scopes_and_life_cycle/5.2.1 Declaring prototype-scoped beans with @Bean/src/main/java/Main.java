import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        CommentService commentService1 = context.getBean(CommentService.class);
        CommentService commentService2 = context.getBean(CommentService.class);

        boolean b = commentService1 == commentService2;
        System.out.println("Are both CommentService instances the same? " + b);
    }
}
