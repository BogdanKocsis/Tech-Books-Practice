package proxies;

import org.springframework.stereotype.Component;

@Component
public class EmailCommentNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendComment(model.Comment comment) {
        System.out.println("Sending email notification for comment: " + comment.getText());
    }
}
