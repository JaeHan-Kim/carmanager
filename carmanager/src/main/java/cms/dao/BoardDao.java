package cms.dao;

import java.util.List;
import java.util.Map;

import cms.domain.Board;

public interface BoardDao {
  List<Board> selectList(Map<String,Object> paramMap);
  
  int countAll();
}







