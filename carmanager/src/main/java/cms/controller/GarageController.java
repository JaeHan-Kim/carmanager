package cms.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cms.domain.AjaxResult;
import cms.domain.Garage;
import cms.domain.Makers;
import cms.domain.Model;
import cms.domain.Official;
import cms.service.GarageService;
import cms.service.MakersService;
import cms.service.ModelService;
import cms.service.MyGoodsService;
import cms.service.OfficialService;
import cms.service.RefuelService;

@Controller
@RequestMapping("/garage/*")
public class GarageController {
  public static final Logger log = Logger.getLogger(GarageController.class);
  
  @Autowired GarageService garageService;
  @Autowired RefuelService refuelService;
  @Autowired MakersService makersService;
  @Autowired ModelService modelService;
  @Autowired OfficialService officialService;
  @Autowired MyGoodsService mygoodsService;
  @Autowired ServletContext servletContext;
  
  @RequestMapping("list")
  public Object carList(int no) throws Exception {

    List<Garage> garages = garageService.listAll(no);
    
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("data", garages);
    return resultMap;  

  }
  
  @RequestMapping(value="detail", method=RequestMethod.GET)
  public Object carDetail(int no) throws Exception {
    
    Garage garages = garageService.carDetail(no);
    //log.debug(garages.toString());
    return new AjaxResult("success", garages);
  }
  
  @RequestMapping(value="delete", method=RequestMethod.POST)
  public Object deleteCar(int no, int userNo) throws Exception {
//  	log.debug("삭제할 차량 : " + no + "접속한 유저 : " + userNo);
  	mygoodsService.carDelete(no);
    refuelService.carDelete(no);
    garageService.carDelete(no);
    Garage garage = garageService.searchFirstCar(userNo);
    if (garage == null) {
    	return new AjaxResult("success", new Garage(0));
    	//garage.setMyCarNo(0);
    }
    //log.debug(garage.toString());
    return new AjaxResult("success", garage);
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
  @RequestMapping(value="refuellist", method=RequestMethod.GET)
  public Object refuelList(int no) {
  	
  	Official model = officialService.effiSearch(no);
  	
  	HashMap<String, Object> resultMap = new HashMap<>();
  	resultMap.put("data", model);
  	return resultMap;
  }
  @RequestMapping(value="addmycar", method=RequestMethod.POST)
  public AjaxResult addMyCar(Garage garage) {
  	log.debug(garage.toString());
  	int myCarCnt = garageService.myCarCount(garage.getMemberNo());
  	log.debug("보유한 차량 갯수는 : " + myCarCnt);
  	if (myCarCnt > 2) {
  		return new AjaxResult("failure", null);
  	}
  	garageService.addMyCar(garage);
  	
  	garage = garageService.searchFirstCar(garage.getMemberNo());
  	log.debug(garage.toString());
  	return new AjaxResult("success", garage);
  }
}
