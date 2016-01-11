package cms.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cms.dao.MemberDao;
import cms.domain.AjaxResult;
import cms.domain.Member;

@Controller("ajax.AuthController")
@RequestMapping("/auth/ajax/*")
public class AuthController {   
  static public Logger log = Logger.getLogger(AuthController.class);

  @Autowired MemberDao memberDao;
  
  @RequestMapping(value="login", method=RequestMethod.POST)
  public AjaxResult login(
      String email,
      String password,
      HttpServletResponse response,
      HttpSession session) {
	  
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("email", email);
    paramMap.put("password", password);
        
    Member member = memberDao.selectOneByEmailPassword(paramMap);
    
    System.out.println(member);
    
    if (member == null) {
      session.invalidate();
      return new AjaxResult("failure", null);
    }
    
//    session.setAttribute("loginUser", member);
    
    return new AjaxResult("success", member);
  }
  
  @RequestMapping(value="join", method=RequestMethod.GET)
  public String form() {
    return "login";
  }
  
  @RequestMapping(value="join", method=RequestMethod.POST)
  public AjaxResult join(Member member) throws Exception {
    
    System.out.println(member);
    
    memberDao.insert(member);
    
    return new AjaxResult("success", member);
  }
  
}
