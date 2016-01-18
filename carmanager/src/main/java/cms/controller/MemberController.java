package cms.controller;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cms.dao.MemberDao;
import cms.domain.AjaxResult;
import cms.domain.Member;

@Controller("ajax.MemberController")
@RequestMapping("/mypage/ajax/*")
public class MemberController {
  public static final String SAVED_DIR = "../img/member";
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
  public AjaxResult update(
		  String memberNo,
		  String nickName,
		  String password
		  ) throws Exception {

//    String fileName = MultipartHelper.generateFilename(photofile.getOriginalFilename());
//    
//    File attachFile = new File(servletContext.getRealPath("/img") 
//        + "/member/" + fileName);
//
//    photofile.transferTo(attachFile);
	
//	String newFileName = null;
//    
//    if (photofile.getSize() > 0) {
//      newFileName = MultipartHelper.generateFilename(photofile.getOriginalFilename());  
//      File attachfile = new File(servletContext.getRealPath(SAVED_DIR) + "/" + newFileName);
//      photofile.transferTo(attachfile);
//    }
    
    Member member = new Member();
    member.setMemberNo(Integer.parseInt(memberNo));
    member.setNickName(nickName);
    member.setPassword(password);
    
//    if (newFileName != null) {
//      member.setMemberPhoto(fileName);
//    } else if (newFileName == null && photo.length() > 0) {
//      member.setMemberPhoto(photo);
//    }
    
    if (memberDao.update(member) <= 0) {
    	return new AjaxResult("failure", null);
    }
    
    return new AjaxResult("success", null);
  }
}