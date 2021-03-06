package cms.dao;

import java.util.HashMap;
import java.util.List;

import cms.domain.Refuel;

public interface RefuelDao {
	public List<Refuel> selectRefuelList(int no);
	
	public List<Refuel> selectCostAvg();
	
	public List<Refuel> selectMemberCostAvg(int no);
	
	int delete(int no);
	
	public Refuel selectOilList(int no);

  public int addRefuelCost(Refuel refuel);
  
	public Refuel selectRefuel(int no);
	
	public List<Refuel> selectMonthAvg(int no);

	public List<Refuel> selectMonthList(int no);
	
  public Object selectRefuelOne(HashMap<String, Object> resultMap);
  
  public int updateRefuel(HashMap<String, Object> resultMap);
}
