package cms.dao;

import java.util.List;

import cms.domain.MyGoods;

public interface MyGoodsDao {
  
  public int insert(MyGoods mygoods);
  
  public int update(MyGoods mygoods);  

  public MyGoods selectMygoods(int no);
  
  public MyGoods selectChangeMygoods(MyGoods mygoods);
  
  public List<MyGoods> selectList(int no);
  
  public int delete(int no);
}
