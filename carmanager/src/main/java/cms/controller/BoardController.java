package cms.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cms.dao.BoardDao;
import cms.domain.Board;

@Controller("ajax.CommunityController")
@RequestMapping("/community/ajax/*")
public class BoardController { 
  
  @Autowired BoardDao boardDao;
  @Autowired ServletContext servletContext;
  
  @RequestMapping("list")
  public Object list(
      @RequestParam(defaultValue="1") int page,
      @RequestParam(defaultValue="8") int pageSize) throws Exception {
    
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (page - 1) * pageSize);
    paramMap.put("length", pageSize);
    
    List<Board> boards = boardDao.selectList(paramMap);
    
    int count = boardDao.countAll();
    int page_link = 7;
    
    HashMap<String, Object> selectMap = new HashMap<>();
    selectMap.put("count", count);
    selectMap.put("pageSize", pageSize);
    selectMap.put("page_link", page_link);
    
    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("data", boards);
    resultMap.put("pageAttribute", selectMap);
    
    
    return resultMap;
  }
  
}