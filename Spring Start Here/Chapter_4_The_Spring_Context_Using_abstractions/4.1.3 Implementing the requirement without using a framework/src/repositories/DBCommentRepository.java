package repositories;

import model.Comment;

public class DBCommentRepository implements CommentRepository {
    @Override
    public void storeComment(Comment comment) {
        // Code to save the comment to the database
        System.out.println("Storing comment: " + comment.getText());
    }
}
