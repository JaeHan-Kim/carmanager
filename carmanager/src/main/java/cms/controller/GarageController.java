package cms.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cms.domain.Garage;
import cms.domain.Refuel;
import cms.service.GarageService;
import cms.service.RefuelService;

@Controller
// @RequestMapping("/main/*")
public class GarageController {
  /*public static final Logger log = Logger.getLogger(GarageController.class);
  
  @Autowired GarageService garageService;
  @Autowired RefuelService refuelService;
  @Autowired ServletContext servletContext;
  
  @RequestMapping("list")
  public Object carList(
  		HttpSession session) throws Exception {

		int no = 1;
    List<Garage> garages = garageService.listAll(no);
    List<Refuel> refuels = refuelService.listAll(no);
    List<Refuel> costAvg = refuelService.costAvg();
    List<Refuel> myCostAvg = refuelService.myCostAvg(no);
    
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("data", garages);
    resultMap.put("refuelList", refuels);
    resultMap.put("memCostAvg", costAvg);
    resultMap.put("myCostAvg", myCostAvg);
    return resultMap;  

  }
  
  @RequestMapping(value="select", method=RequestMethod.GET)
  public Object selList(int no,
  		HttpSession session) throws Exception {
  	//log.debug("현재 차량은 " + no + "입니다.");
  	
  	List<Garage> garages = garageService.listAll(no);
    List<Refuel> refuels = refuelService.listAll(no);
    List<Refuel> costAvg = refuelService.costAvg();
    List<Refuel> myCostAvg = refuelService.myCostAvg(no);
    
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("data", garages);
    resultMap.put("refuelList", refuels);
    resultMap.put("memCostAvg", costAvg);
    resultMap.put("myCostAvg", myCostAvg);
    return resultMap; 
  }*/
  
}
