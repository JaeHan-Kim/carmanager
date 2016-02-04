package cms.dao;

import java.util.List;
import java.util.Map;

import cms.domain.Board;
import cms.domain.Garage;

public interface BoardDao {
  List<Board> selectList(Map<String,Object> paramMap);
  
  List<Board> searchList(Map<String,Object> paramMap);
  
  int countAll();
  
  int countSearch(Map<String,Object> paramMap);
  
  Board selectOne(int no);
  
  int viewsUp(int no);
  
  int likesUp(int no);
  
  // public int insertText(Board board);
}







