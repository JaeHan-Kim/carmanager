package cms.dao;

import java.util.Map;

import cms.domain.Member;

public interface MemberDao {
  
  int insert(Member member);
  
  Member selectOneByEmailPassword(Map<String,Object> paramMap);
  
  int checkEmail(Member member);
  
  int checkNickname(Member member);
  
  Member selectOne(int no);
  
  int update(Member member);
}