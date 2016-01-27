package cms.dao;

import java.util.List;

import cms.domain.Goods;

public interface GoodsDao {
	
  public List<Goods> selectList();

}
