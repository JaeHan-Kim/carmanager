package cms.service.support;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cms.dao.RefuelDao;
import cms.domain.Refuel;
import cms.service.RefuelService;

@Service
public class DefaultRefuelService implements RefuelService {
	@Autowired RefuelDao refuelDao;

	@Override
	public List<Refuel> listAll(int no) {
		return refuelDao.selectRefuelList(no);
	}

	@Override
	public List<Refuel> costAvg() {
		return refuelDao.selectCostAvg();
	}

  @Override
  public List<Refuel> myCostAvg(int no) {
    return refuelDao.selectMemberCostAvg(no);
  }

  @Override
  public int carDelete(int no) {
    return refuelDao.delete(no);
  }

  @Override
  public Refuel oilList(int no) {
    return refuelDao.selectOilList(no);
  }

  @Override
  public int addRefuel(Refuel refuel) {
    return refuelDao.addRefuelCost(refuel);
  }
	
  @Override
  public Refuel retrieve(int no) {
    return refuelDao.selectRefuel(no);
  }

  @Override
  public List<Refuel> monthAvg(int no) {
    return refuelDao.selectMonthAvg(no);
  }	

  @Override
  public List<Refuel> monthList(int no) {
    return refuelDao.selectMonthList(no);
  }

  @Override
  public Object refuelOne(Date date, int selectCar) {
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("date", date);
    resultMap.put("selectCar", selectCar);
    return refuelDao.selectRefuelOne(resultMap);
  }

  @Override
  public Object changeRefuel(Date date, int myCarNo, Date refuelDate, 
      int mile, int literCost, int cost, float liter) {
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("date", date);
    resultMap.put("myCarNo", myCarNo);
    resultMap.put("refuelDate", refuelDate);
    resultMap.put("mile", mile);
    resultMap.put("literCost", literCost);
    resultMap.put("cost", cost);
    resultMap.put("liter", liter);
    return refuelDao.updateRefuel(resultMap);
  }

}
