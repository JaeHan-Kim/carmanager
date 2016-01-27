package cms.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cms.domain.AjaxResult;
import cms.domain.Garage;
import cms.domain.Goods;
import cms.domain.MyGoods;
import cms.domain.Refuel;
import cms.service.GarageService;
import cms.service.GoodsService;
import cms.service.MyGoodsService;
import cms.service.RefuelService;

@Controller
@RequestMapping("/mygoods/*")
public class MyGoodsController {
  public static final Logger log = Logger.getLogger(MyGoodsController.class);
  
  @Autowired MyGoodsService mygoodsService;
  @Autowired RefuelService refuelService;
  @Autowired GarageService garageService;
  @Autowired GoodsService goodsService;
  
  @Autowired ServletContext servletContext;
  
  @RequestMapping("selectCurrentMile")
  public Object selectCurrentMile(int no) throws Exception {
    //소모품 교체 기록 유무 검사 
	MyGoods mygoods = mygoodsService.retrieve(no);
	if (mygoods == null) {
	  
	  Garage garage = garageService.retrieve(no);
	  if (garage == null) {
	    return new AjaxResult("failure", null);
	  } 
	
	  Refuel refuel = refuelService.retrieve(no);
	  
	  for (int i = 1; i <=9; i++) {	
        MyGoods addmygoods = new MyGoods();
	    addmygoods.setGarageNo(no);
	    addmygoods.setGoodsNo(i);
	    addmygoods.setChangeMile(garage.getMile());
	    mygoodsService.addMygoods(addmygoods);	
	  }
	  		  
	  List<Goods> goods = goodsService.getGoodsList();		  
    
	  HashMap<Integer, Integer> restmiles = new HashMap<>();
	  for(Goods good : goods) {
	    int restmile = garage.getMile() + good.getLifeMile() - (garage.getMile() + (refuel.getMile() - garage.getMile()));
        restmiles.put(good.getGoodsNo(), restmile); 
	  }
	  
	  HashMap<String,Object> resultMap = new HashMap<>();
      resultMap.put("status", "success");
      resultMap.put("data", restmiles);
	  return resultMap;
    }
	
	//소모품 교체 기록 있을때,
	Refuel refuel = refuelService.retrieve(no);
	List<Goods> goods = goodsService.getGoodsList();		  
	
	HashMap<Integer, Integer> restmiles = new HashMap<>();
	for(Goods good : goods) {
	  MyGoods inputmygoods = new MyGoods();
	  inputmygoods.setGarageNo(no);
	  inputmygoods.setGoodsNo(good.getGoodsNo());
	  
	  MyGoods resultmygoods = mygoodsService.searchMygoods(inputmygoods);

	  int refuelmile;
	  if (refuel == null) {
	    refuelmile = resultmygoods.getChangeMile();
	  } else {
		refuelmile = resultmygoods.getChangeMile() + (refuel.getMile() - resultmygoods.getChangeMile());
	  }
		
	  int restMile = (resultmygoods.getChangeMile() + good.getLifeMile()) - refuelmile;
	  
	  restmiles.put(good.getGoodsNo(), restMile); 
    }
		  
	HashMap<String,Object> resultMap = new HashMap<>();
	resultMap.put("status", "success");
	resultMap.put("data", restmiles);
	return resultMap;
  }
  
  @RequestMapping("update")
  public AjaxResult update(MyGoods mygoods) throws Exception {
    Refuel refuel = refuelService.retrieve(mygoods.getGarageNo());
	  
	mygoods.setChangeMile(refuel.getMile());

	mygoodsService.updateMygoods(mygoods);
	  
	return new AjaxResult("success", null);
  }
  
}
