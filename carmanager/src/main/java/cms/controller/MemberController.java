package cms.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cms.dao.MemberDao;

@Controller("ajax.MemberController")
@RequestMapping("/member/ajax/*")
public class MemberController {
  @Autowired MemberDao memberDao;
  @Autowired ServletContext servletContext;
  
}