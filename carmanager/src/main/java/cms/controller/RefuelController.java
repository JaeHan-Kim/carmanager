package cms.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
      return new AjaxResult("failure", null);
    }
    log.debug(refuel.toString());
    return new AjaxResult("success", refuel);
    
  }
  /*
  @RequestMapping(value="refuellist", method=RequestMethod.GET)
  public Object refuelList(int no) {
    
    Official model = officialService.effiSearch(no);
    
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("data", model);
    return resultMap;

  }*/
  
  
}
