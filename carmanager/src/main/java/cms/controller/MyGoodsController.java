package cms.controller;

import java.sql.Date;
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
		  
	  List<Goods> goods = goodsService.getGoodsList();		  
    
	  HashMap<Integer, Integer> restmiles = new HashMap<>();
	  for(Goods good : goods) {
	    int restmile = good.getLifeMile() - garage.getMile();
        restmiles.put(good.getGoodsNo(), restmile); 
	  }
	  
	  HashMap<String,Object> resultMap = new HashMap<>();
      resultMap.put("status", "success");
      resultMap.put("data", restmiles);
	  return resultMap;
    }
	
	//소모품 교체 기록 있을때,
    Garage garage = garageService.retrieve(no);
	List<Goods> goods = goodsService.getGoodsList();		  

	HashMap<Integer, Integer> restmiles = new HashMap<>();
	HashMap<Integer, Date> changedates = new HashMap<>();
	for(Goods good : goods) {
	  MyGoods inputmygoods = new MyGoods();
	  inputmygoods.setGarageNo(no);
	  inputmygoods.setGoodsNo(good.getGoodsNo());
	  
	  MyGoods resultmygoods = mygoodsService.searchMygoods(inputmygoods);

	  if (resultmygoods == null) {
	    int restMile = good.getLifeMile() - garage.getMile();
	    restmiles.put(good.getGoodsNo(), restMile); 
	  } else {
      	int changeMile = resultmygoods.getChangeMile() + (garage.getMile() - resultmygoods.getChangeMile());
	    int restMile = (resultmygoods.getChangeMile() + good.getLifeMile()) - changeMile;
	    restmiles.put(good.getGoodsNo(), restMile);
	    changedates.put(good.getGoodsNo(), resultmygoods.getChangeDate());
	  }
    }

	
	
	HashMap<String,Object> resultMap = new HashMap<>();
	resultMap.put("status", "success");
	resultMap.put("data", restmiles);
	resultMap.put("datadate", changedates);
	return resultMap;
  }
  
  @RequestMapping("update")
  public AjaxResult update(MyGoods mygoods) throws Exception {
    if (mygoodsService.searchMygoods(mygoods) == null) {
  	  Garage garage = garageService.retrieve(mygoods.getGarageNo());
  	  mygoods.setChangeMile(garage.getMile());
  	  mygoodsService.addMygoods(mygoods);
  	  return new AjaxResult("success", null);
    } else {
  	  Garage garage = garageService.retrieve(mygoods.getGarageNo());
  	  mygoods.setChangeMile(garage.getMile());
  	  mygoodsService.updateMygoods(mygoods);
	  return new AjaxResult("success", null);
    }
  }
  
}
