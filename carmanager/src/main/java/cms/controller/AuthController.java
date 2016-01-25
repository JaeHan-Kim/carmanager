package cms.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cms.dao.MemberDao;
import cms.domain.AjaxResult;
import cms.domain.Member;
import cms.util.MultipartHelper;
import net.coobird.thumbnailator.Thumbnails;

@Controller("ajax.AuthController")
@RequestMapping("/auth/ajax/*")
public class AuthController {   
  static public Logger log = Logger.getLogger(AuthController.class);

  public static final String SAVED_DIR = "/img/member";
  
  @Autowired MemberDao memberDao;
  @Autowired ServletContext servletContext;
  
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
    
    return new AjaxResult("success", member);
  }
  
  @RequestMapping(value="join", method=RequestMethod.GET)
  public String form() {
    return "login";
  }
  
  @RequestMapping(value="join", method=RequestMethod.POST)
  public AjaxResult join(MultipartHttpServletRequest request) throws Exception {

    Iterator<String> itr =  request.getFileNames();
    MultipartFile mpf = request.getFile(itr.next());
 
    String newFileName = null;
    
    if (mpf.getSize() > 0) {
      newFileName = MultipartHelper.generateFilename(mpf.getOriginalFilename());  
      File attachfile = new File(servletContext.getRealPath(SAVED_DIR) 
                                  + "/" + newFileName);
      mpf.transferTo(attachfile);
      
      makeThumbnailImage(
          servletContext.getRealPath(SAVED_DIR) + "/" + newFileName, 
          servletContext.getRealPath(SAVED_DIR) + "/m-" + newFileName + ".png");
    }    

    Member member = new Member();
    member.setEmail(request.getParameter("email"));
    member.setNickName(request.getParameter("nickName"));
    member.setPassword(request.getParameter("password"));
    member.setMemberPhoto(newFileName);

    System.out.println(member);

    memberDao.insert(member);
    
    return new AjaxResult("success", member);
  }
  
  /* 패스워드 정규표현식에 대한 검사 */
  @RequestMapping(value="checkPassword", method=RequestMethod.POST)
  public AjaxResult checkPassword(Member member) throws Exception {
    
    String password = member.getPassword();
    String regex = "^[a-zA-Z0-9_]{6,12}$";
    
    boolean passwordCheck = Pattern.matches(regex, password);
    
    if(passwordCheck == true) {
  
      return new AjaxResult("success", member);
    }
    
    return new AjaxResult("notPassword", null);
  }
  
  private void makeThumbnailImage(String originPath, String thumbPath) 
      throws IOException {
    Thumbnails.of(new File(originPath))
    .size(60,44)
    .outputFormat("png")
    .outputQuality(1.0)
    .toFile(new File(thumbPath));
  }
  
}
