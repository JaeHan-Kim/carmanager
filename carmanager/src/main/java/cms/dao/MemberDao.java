package cms.dao;

import java.util.Map;

import cms.domain.Member;

public interface MemberDao {
  
  int insert(Member member);

  int update(Member member);
  
  int imgUpdate(Member member);
  
  Member selectOne(int no);

  Member selectOneByEmailPassword(Map<String,Object> paramMap);
  
  int checkEmail(Member member);
  
  int checkNickname(Member member);
  
  
}