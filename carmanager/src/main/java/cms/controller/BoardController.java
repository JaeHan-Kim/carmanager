package cms.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cms.dao.BoardDao;
import cms.dao.PhotoesDao;
import cms.domain.AjaxResult;
import cms.domain.Board;
import cms.domain.Photoes;
import cms.util.MultipartHelper;
import net.coobird.thumbnailator.Thumbnails;

@Controller("ajax.CommunityController")
@RequestMapping("/community/ajax/*")
public class BoardController { 
  
	public static final Logger log = Logger.getLogger(GarageController.class);
	
	
	public static final String SAVED_DIR = "/img/community";
  @Autowired BoardDao boardDao;
  @Autowired PhotoesDao photoesDao;
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
  
  @RequestMapping(value="search", method=RequestMethod.GET)
  public Object search(
      @RequestParam(defaultValue="1") int page,
      @RequestParam(defaultValue="8") int pageSize,
      String searchKeyword, 
      String title, 
      String nickname, 
      String category
      ) throws Exception {
    
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (page - 1) * pageSize);
    paramMap.put("length", pageSize);
    
    System.out.println(category);
    
    if (category != null) {
      paramMap.put("category", category);
      if (title != null) {
        searchKeyword = "title";
        paramMap.put("title", title);
      } else if (nickname != null) {
        searchKeyword = "nickname";
        paramMap.put("nickname", nickname);
      }
    } else if (title != null) {
      searchKeyword = "title";
      paramMap.put("title", title);
    } else if (nickname != null) {
      searchKeyword = "nickname";
      paramMap.put("nickname", nickname);
    }

    paramMap.put("keyword", searchKeyword);
    
    List<Board> boards = boardDao.searchList(paramMap);
    
    int count = boardDao.countSearch(paramMap);
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
  
  @RequestMapping("detail")
  public Object detail(int no) throws Exception {
    boardDao.viewsUp(no);
    Board board = boardDao.selectOne(no);
    return new AjaxResult("success", board);
  }
  
  @RequestMapping("likesUp")
  public Object likesUp(int no) throws Exception {
    boardDao.likesUp(no);
    return new AjaxResult("success", null);
  }
  
  @RequestMapping(value="imageUpload", method=RequestMethod.POST)
  @ResponseBody
  public Object imageUpload(MultipartHttpServletRequest request) throws Exception {
  	int cnt = Integer.parseInt(request.getParameter("imageCnt"));
  	int find = 0;
  	String newFileName = null;
  	String reFileName = "../img/community/";
  	
    if (request.getFileMap().size() != 0) { 
    
      Iterator<String> itr =  request.getFileNames();
      MultipartFile mpf = request.getFile(itr.next());
      
      if (mpf.getSize() > 0) {
        newFileName = MultipartHelper.generateFilename(mpf.getOriginalFilename());  
        File attachfile = new File(servletContext.getRealPath(SAVED_DIR) 
                                    + "/" + newFileName);
        find = newFileName.lastIndexOf('.');
        mpf.transferTo(attachfile);
        if(cnt < 1) {
        	log.debug("첫사진");
        	makeThumbnailImage(
          servletContext.getRealPath(SAVED_DIR) + "/" + newFileName, 
          servletContext.getRealPath(SAVED_DIR) + "/c-" + newFileName.substring(0, find) + ".png");
        }
        reFileName += attachfile.getName();
        log.debug(reFileName);
      }    
    }
    String url = reFileName;
    return url;
  	
  }
  
  @RequestMapping(value="addText", method=RequestMethod.POST)
  public AjaxResult addText(int userNo, String title, String content, String category, String imageFile) {
  	Board board;
  	//  log.debug(userNo + " " + title + " " + content + " " + category + " " + imageFile);
  	HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("userNo", userNo);
    paramMap.put("title", title);
    paramMap.put("content", content);
    paramMap.put("category", category);
    paramMap.put("imageFile", imageFile);
    boardDao.insertText(paramMap);
    board = boardDao.selectBoradNo();
    
    Photoes photo = new Photoes(board.getBoardNo(),imageFile);
    photoesDao.insertPhoto(photo);
    
  	return new AjaxResult("success", null);
  }
  @RequestMapping("update")
  public Object update(int no) throws Exception {
    Board board = boardDao.selectOne(no);
    return new AjaxResult("success", board);
  }
  
  private void makeThumbnailImage(String originPath, String thumbPath) 
      throws IOException {
    Thumbnails.of(new File(originPath))
    .size(260,173)
    .outputFormat("png")
    .outputQuality(1.0)
    .toFile(new File(thumbPath));
  }
}