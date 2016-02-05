package cms.dao;

import java.util.List;

import cms.domain.Comment;

public interface CommentDao {
  List<Comment> selectList(int no);
  
  int insert(Comment comment);
  
  int deleteOne(int no);
  
  int deleteAll(int no);
}