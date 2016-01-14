package cms.service;

import java.util.List;

import cms.domain.Garage;

public interface GarageService {
  List<Garage> listAll(int no);

  Garage carDetail(int no);
  
  int carDelete(int no);
  
  int myCarCount (int no);
  
  int addMyCar(Garage garage);
  
  Garage lastAddCar (int no);
  
}
