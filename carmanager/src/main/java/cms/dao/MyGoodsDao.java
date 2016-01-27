package cms.dao;

import cms.domain.MyGoods;

public interface MyGoodsDao {
  
  public int insert(MyGoods mygoods);
  
  public int update(MyGoods mygoods);  

  public MyGoods selectMygoods(int no);
  
  public MyGoods selectChangeMygoods(MyGoods mygoods);
}
