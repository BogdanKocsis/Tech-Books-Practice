package repositories;

import model.Comment;
import org.springframework.stereotype.Repository;

@Repository
public class DBCommentRepository implements CommentRepository {
    @Override
    public void storeComment(Comment comment) {
        // Code to save the comment to the database
        System.out.println("Storing comment: " + comment.getText());
    }
}
