package cms.dao;

import java.util.List;

import cms.domain.Garage;

public interface GarageDao {
  public List<Garage> selectList(int no);

  public Garage selectDetail(int no);
  
  public int selectCount(int no);
  
  public int insertCar(Garage garage);
  
  public Garage selectOne(int no);

  public int delete(int no);
  
}