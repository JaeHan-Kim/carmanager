package cms.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;

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

@Controller("ajax.MemberController")
@RequestMapping("/mypage/ajax/*")
public class MemberController {
  public static final String SAVED_DIR = "/img/member";
  static public Logger log = Logger.getLogger(AuthController.class);
	  
  @Autowired MemberDao memberDao;
  @Autowired ServletContext servletContext;
  
  @RequestMapping(value="detail", method=RequestMethod.POST) 
  public Object detail(int no) throws Exception {
    Member member = memberDao.selectOne(no);
//    String fileName = member.getMemberPhoto();
//    member.setMemberPhoto(servletContext.getRealPath("/img") + "/member/" + fileName);
//    System.out.println(servletContext.getRealPath("/img") + "/member/" + fileName);
    
    return new AjaxResult("success", member);
  }

/*  
  @RequestMapping(value="upadd", method=RequestMethod.POST) 
  public AjaxResult upadd(MultipartFile uploadfile){
  	log.debug(uploadfile.getOriginalFilename());
  	log.debug("들어왔다");
  	
  	return new AjaxResult("success", null);
  }
*/
  
  @RequestMapping(value="update", method=RequestMethod.POST)
  public AjaxResult update(MultipartHttpServletRequest request) throws Exception {

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

    System.out.println(request.getParameter("email"));
    
    Member member = new Member();
    member.setEmail(request.getParameter("email"));
    member.setPassword(request.getParameter("password"));
    member.setMemberPhoto(newFileName);
    
    if (memberDao.update(member) <= 0) {
    	return new AjaxResult("failure", null);
    }
    
    return new AjaxResult("success", null);
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