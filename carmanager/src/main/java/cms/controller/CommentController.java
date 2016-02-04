package cms.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cms.dao.CommentDao;
import cms.domain.AjaxResult;
import cms.domain.Comment;

@Controller("ajax.CommentController")
@RequestMapping("/comment/ajax/*")
public class CommentController { 
  
  @Autowired CommentDao commentDao;
  
  @RequestMapping("list")
  public Object list(int no) throws Exception {
    List<Comment> comments = commentDao.selectList(no);

    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("data", comments);
    
    return resultMap;
  }
  
  @RequestMapping(value="add", method=RequestMethod.POST)
  public AjaxResult add(Comment comment) {
    commentDao.insert(comment);
    
    return new AjaxResult("success", comment);
  }
  
  @RequestMapping("delete")
  public String delete(int no) throws Exception {

    if (commentDao.deleteOne(no) <= 0) {
      return "failure";
    } 

    return "success";
  }
  
}