package cms.dao;

import java.util.Map;

import cms.domain.Member;

public interface MemberDao {
  
  int insertAll(Member member);
  
  int insertNotPhoto(Member member);

  int updateBoth(Member member);
  
  int updatePhoto(Member member);
  
  int updatePwd(Member member);
  
  int imgUpdate(Member member);
  
  Member selectOne(int no);
  
  String selectPhoto(String email);

  Member selectOneByEmailPassword(Map<String,Object> paramMap);
  
  int checkEmail(Member member);
  
  int checkNickname(Member member);
  
  
}