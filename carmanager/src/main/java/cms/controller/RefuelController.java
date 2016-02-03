package cms.controller;

import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cms.domain.AjaxResult;
import cms.domain.Refuel;
import cms.service.GarageService;
import cms.service.OfficialService;
import cms.service.RefuelService;

@Controller
@RequestMapping("/refuel/*")
public class RefuelController {
  public static final Logger log = Logger.getLogger(RefuelController.class);

  @Autowired GarageService garageService;
  @Autowired RefuelService refuelService;
  @Autowired OfficialService officialService;
  
  @RequestMapping("list")
  public Object oilList(int no) throws Exception {

    Refuel refuel = refuelService.oilList(no);
    
    if (refuel == null) {
    	log.debug("---------------");
    	log.debug(" 들어옴");
    	log.debug("---------------");
    	
      return new AjaxResult("failure", new Refuel(garageService.carDetail(no).getFuelName()));
    }
    //log.debug(refuel.toString());
    return new AjaxResult("success", refuel);
    
  }
  @RequestMapping("monthList")
  public Object selectMonthAvg(int no) throws Exception {
    List<Refuel> refuels = refuelService.monthList(no);
    //log.debug(refuels);
    return new AjaxResult("success", refuels);
  }

  @RequestMapping("monthCost")
  public Object selectMonthList(int no) throws Exception {
    List<Refuel> refuels = refuelService.monthAvg(no);
    //log.debug(refuels);
    return new AjaxResult("success", refuels);
  }
  
  @RequestMapping(value="addRefuel", method=RequestMethod.POST)
  public AjaxResult addRefuel(Refuel refuel) throws Exception {
    
    if (garageService.carDetail(refuel.getMyCarNo()).getMile() > refuel.getMile()) {
    	log.debug("------------------------");
    	log.debug(garageService.carDetail(refuel.getMyCarNo()).getMile());
    	log.debug("------------------------");
      return new AjaxResult("failure", null);
    }

    garageService.updateMile(refuel.getMile(), refuel.getMyCarNo());
    refuelService.addRefuel(refuel);
    
    //log.debug(refuel.toString());
    return new AjaxResult("success", refuel);
  }
  
  @RequestMapping("refuelOne")
  public Object refuelOne(Date date, int selectCar) throws Exception {
    
    Object refuel = refuelService.refuelOne(date, selectCar);
    log.debug(refuel);
    //log.debug(refuel.toString());
    
    if (refuel == null) {
      return new AjaxResult("failure", refuel);
    }
    
    log.debug(refuel.toString());
    return new AjaxResult("success", refuel);
  }
  
  @RequestMapping("refuelOne")
  public Object updateRefuel(Refuel refuel) throws Exception {
    
    refuelService.changeRefuel(refuel);
    
    return new AjaxResult("success", refuel);
  }
  
}
