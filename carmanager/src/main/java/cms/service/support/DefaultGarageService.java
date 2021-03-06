package cms.service.support;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cms.dao.GarageDao;
import cms.domain.Garage;
import cms.service.GarageService;

@Service
public class DefaultGarageService implements GarageService {
  @Autowired GarageDao garageDao;

  @Override
  public List<Garage> listAll(int no) {
    return garageDao.selectList(no);
  }

  @Override
  public Garage carDetail(int no) {
    return garageDao.selectDetail(no);
  }

	@Override
	public int myCarCount(int no) {
		return garageDao.selectCount(no);
	}

	@Override
	public int addMyCar(Garage garage) {
		return garageDao.insertCar(garage);
	}

	@Override
	public Garage lastAddCar(int no) {
		return garageDao.selectOne(no);
	}

	@Override
  public int carDelete(int no) {
    return garageDao.delete(no);
  }

	@Override
	public Garage searchFirstCar(int no) {
		return garageDao.selectFirstCar(no);
	}
	
  @Override
  public Garage retrieve(int no) {
    return garageDao.selectGarage(no);
  }

  @Override
  public int updateMile(int mile, int myCarNo) {
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("mile", mile);
    resultMap.put("grno", myCarNo);
    return garageDao.updateMile(resultMap);
  }
}