package cms.controller;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cms.domain.AjaxResult;
import cms.domain.Garage;
import cms.service.GarageService;

@Controller
@RequestMapping("/goods/*")
public class GoodsController {
  public static final Logger log = Logger.getLogger(GoodsController.class);
  
  @Autowired GarageService garageService;
  @Autowired ServletContext servletContext;
  
  
  @RequestMapping(value="carInfo", method=RequestMethod.GET)
  public AjaxResult addMyCar(int no) {
  
  	Garage garage = garageService.carDetail(no);
  	
  	log.debug(garage.toString());

  
  	return new AjaxResult("success", garage);
  }
}
