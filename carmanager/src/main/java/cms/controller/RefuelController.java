package cms.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cms.domain.AjaxResult;
import cms.domain.Refuel;
import cms.service.GarageService;
import cms.service.RefuelService;

@Controller
@RequestMapping("/refuel/*")
public class RefuelController {
  public static final Logger log = Logger.getLogger(RefuelController.class);
  
  @Autowired GarageService garageService;
  @Autowired RefuelService refuelService;
  
  
  @RequestMapping("list")
  public Object oilList(int no) throws Exception {
    
    Refuel refuels = refuelService.oilList(no);
    log.debug(refuels.toString());

    return new AjaxResult("success", refuels);
  }
  
  
}
