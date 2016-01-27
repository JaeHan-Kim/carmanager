package cms.dao;

import java.util.List;
import java.util.Map;

import cms.domain.Garage;

public interface GarageDao {
  public List<Garage> selectList(int no);

  public Garage selectDetail(int no);
  
  public int selectCount(int no);
  
  public int insertCar(Garage garage);
  
  public Garage selectOne(int no);

  public int delete(int no);
  
  public Garage selectFirstCar(int no);
  
  public Garage selectGarage(int no);

  public int updateMile(Map<String, Object> resultMap);
}