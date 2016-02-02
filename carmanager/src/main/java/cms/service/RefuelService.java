package cms.service;

import java.sql.Date;
import java.util.List;

import cms.domain.Refuel;

public interface RefuelService {
  List<Refuel> listAll(int no);
  
  List<Refuel> costAvg();
  
  List<Refuel> myCostAvg(int no);
  
  int carDelete(int no);
  
  Refuel oilList(int no);
  
  int addRefuel(Refuel refuel);

  Refuel retrieve(int no);  
  
  List<Refuel> monthList(int no);
  
  List<Refuel> monthAvg(int no);
  
  Object refuelOne(Date date, int selectCar);
}
