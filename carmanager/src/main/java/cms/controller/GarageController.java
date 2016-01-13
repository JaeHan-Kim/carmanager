package cms.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cms.domain.AjaxResult;
import cms.domain.Garage;
import cms.service.GarageService;
import cms.service.RefuelService;

@Controller
@RequestMapping("/garage/*")
public class GarageController {
  public static final Logger log = Logger.getLogger(GarageController.class);
  
  @Autowired GarageService garageService;
  @Autowired RefuelService refuelService;
  @Autowired ServletContext servletContext;
  
  @RequestMapping("list")
  public Object carList(
  		HttpSession session, int no) throws Exception {

    List<Garage> garages = garageService.listAll(no);
    
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("data", garages);
    return resultMap;  

  }
  
  @RequestMapping("detail")
  public Object carDetail(
      HttpSession session, int no) throws Exception {
    
    List<Garage> garages = garageService.carDetail(no);
    
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("data", garages);
    return new AjaxResult("success", garages);
    
  }
  
}
