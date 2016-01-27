package cms.service;

import cms.domain.MyGoods;

public interface MyGoodsService {

  int addMygoods(MyGoods mygoods);

  int updateMygoods(MyGoods mygoods);
  
  MyGoods retrieve(int no);

  MyGoods searchMygoods(MyGoods mygoods);
}



