package pe.edu.upc.aww.werecycle.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.aww.werecycle.entities.Comment;

import java.util.List;

public interface ICommentService {
    public void insert(Comment comment);

    public List<Comment>list();
    public void delete(int idComment);
    List<String[]>QuantityOfCommentsForPublication();
    public List<Comment> findbyidPublication(@Param("idPublication") int idPublication);

}
