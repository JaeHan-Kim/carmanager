package cms.service.support;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cms.controller.MyGoodsController;
import cms.dao.MyGoodsDao;
import cms.domain.MyGoods;
import cms.service.MyGoodsService;

@Service
public class DefaultMyGoodsService implements MyGoodsService {
  public static final Logger log = Logger.getLogger(MyGoodsController.class);

  @Autowired MyGoodsDao mygoodsDao;
  
  @Override
  public int addMygoods(MyGoods mygoods) {
	  return mygoodsDao.insert(mygoods);
  }
  
  @Override
  public int updateMygoods(MyGoods mygoods) {
	  return mygoodsDao.update(mygoods);
  }

  @Override
  public MyGoods retrieve(int no) {
	return mygoodsDao.selectMygoods(no);
  }
  
  @Override
  public MyGoods searchMygoods(MyGoods mygoods) {
	return mygoodsDao.selectChangeMygoods(mygoods);
  }
  
  @Override
  public List<MyGoods> searchList(int no) {
    return mygoodsDao.selectList(no);
  }
}
