package cms.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cms.domain.Garage;
import cms.domain.Makers;
import cms.domain.Model;
import cms.service.GarageService;
import cms.service.MakersService;
import cms.service.ModelService;
import cms.service.RefuelService;

@Controller
@RequestMapping("/garage/*")
public class GarageController {
  public static final Logger log = Logger.getLogger(GarageController.class);
  
  @Autowired GarageService garageService;
  @Autowired RefuelService refuelService;
  @Autowired MakersService makersService;
  @Autowired ModelService modelService;
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
  public Object carDet(
      HttpSession session, int no) throws Exception {
    
    Garage garages = garageService.carDetail(no);
    
    //log.debug(garages.toString());
    
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("data", garages);
    return resultMap;
    
  }
  
  
  @RequestMapping("makerlist")
  public Object makerList() throws Exception {
  	
  	List<Makers> makers = makersService.listAll();
  	
  	//log.debug("---------------------");
  	//log.debug(makers.toString());
  	//log.debug("---------------------");
  	HashMap<String, Object> resultMap = new HashMap<>();
    
  	resultMap.put("status", "success");
  	resultMap.put("makers", makers);
  	return resultMap;
  }

  @RequestMapping(value="modelsearch", method=RequestMethod.GET)
  public Object searchList(int no) {
  	//log.debug(no);
  	
  	List<Model> models = modelService.carSearch(no);
  	
  	//log.debug("---------------------");
  	//log.debug(models.toString());
  	//log.debug("---------------------");
  	HashMap<String, Object> resultMap = new HashMap<>();
  	resultMap.put("datas", models);
  	return resultMap;
  }
}
