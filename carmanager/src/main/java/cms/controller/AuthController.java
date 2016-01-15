package cms.controller;

import java.util.HashMap;
import java.util.regex.Pattern;

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
    
    memberDao.insert(member);
    
    return new AjaxResult("success", member);
  }
  
  /* 이메일 정규표현식에 대한 검사 및 중복검사 */  
  @RequestMapping(value="checkEmail", method=RequestMethod.POST)
  public AjaxResult checkEmail(Member member) throws Exception {
    
    String email = member.getEmail();
    String regex = "\\w+@\\w+\\.\\w+";
    
    boolean emailCheck = Pattern.matches(regex, email);
    
    if (emailCheck == true) {
      if(memberDao.checkEmail(member) > 0)
        return new AjaxResult("failure", null);
    
      return new AjaxResult("success", member);
    } 
    
    return new AjaxResult("notEmail", null);
  }
  
  /* 닉네임 중복검사 */
  @RequestMapping(value="checkNickname", method=RequestMethod.POST)
  public AjaxResult checkNickname(Member member) throws Exception {
    
    if(memberDao.checkNickname(member) > 0)
      return new AjaxResult("failure", null);
  
      return new AjaxResult("success", member);
  }
  
  /* 패스워드 정규표현식에 대한 검사 */
  @RequestMapping(value="checkPassword", method=RequestMethod.POST)
  public AjaxResult checkPassword(Member member) throws Exception {
    
    String password = member.getPassword();
    String regex = "^[a-zA-Z]{1}[a-zA-Z0-9_]{5,13}$";
    
    boolean passwordCheck = Pattern.matches(regex, password);
    
    if(passwordCheck == true) {
  
      return new AjaxResult("success", member);
    }
    
    return new AjaxResult("notPassword", null);
  }
  
}
