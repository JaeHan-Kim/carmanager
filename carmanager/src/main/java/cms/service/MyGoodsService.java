package cms.service;

import java.util.List;

import cms.domain.MyGoods;

public interface MyGoodsService {

  int addMygoods(MyGoods mygoods);

  int updateMygoods(MyGoods mygoods);
  
  MyGoods retrieve(int no);

  MyGoods searchMygoods(MyGoods mygoods);
  
  List<MyGoods> searchList(int no);
  
  int carDelete(int no);
}



