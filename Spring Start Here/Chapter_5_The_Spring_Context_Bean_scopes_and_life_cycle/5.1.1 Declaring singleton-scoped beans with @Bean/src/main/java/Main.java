import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        CommentService commentService1 = context.getBean("commentService", CommentService.class);
        CommentService commentService2 = context.getBean("commentService", CommentService.class);

        boolean b1 = commentService1 == commentService2;
        System.out.println("Are both CommentService instances the same? " + b1);
    }
}
