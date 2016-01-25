package cms.dao;

import java.util.List;

import cms.domain.Refuel;

public interface RefuelDao {
	public List<Refuel> selectRefuelList(int no);
	
	public List<Refuel> selectCostAvg();
	
	public List<Refuel> selectMemberCostAvg(int no);
	
	int delete(int no);
	
	public Refuel selectOilList(int no);

  Refuel addRefuelCost(int no);
}
