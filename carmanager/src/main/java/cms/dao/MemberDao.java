package cms.dao;

import java.util.Map;

import cms.domain.Member;

public interface MemberDao {
  
  int insert(Member member);
  
  Member selectOneByEmailPassword(Map<String,Object> paramMap);
}