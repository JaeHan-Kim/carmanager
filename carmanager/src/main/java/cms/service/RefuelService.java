package cms.service;

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
  
  Refuel monthList(int no);
  
  Refuel monthAvg(int no);
}
