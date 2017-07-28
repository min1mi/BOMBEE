package bitcamp.java93.dao;

import java.util.Map;

import bitcamp.java93.domain.Member;

public interface MemberDao {
  int insert(Member member);
  Member selectOneByEmailPassword(Map<String,Object> valueMap);
}
