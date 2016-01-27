package cms.service.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cms.dao.GoodsDao;
import cms.domain.Goods;
import cms.service.GoodsService;

@Service
public class DefaultGoodsService implements GoodsService{
	
  @Autowired GoodsDao goodsDao;
  
  @Override
  public List<Goods> getGoodsList() {
    return goodsDao.selectList();
  }

}
