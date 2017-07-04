package bitcamp.java93.dao;

import java.util.List;
import java.util.Map;

import bitcamp.java93.domain.Member;

  public interface MemberDao {
    List<Member> selectList(Map<String,Object> valueMap);
    Member selectOneByEmailPassword(Map<String,Object> valueMap);
    Member selectListByNames(Map<String,Object> valueMap);
    Member selectOne(int no);
    int countAll();
    int insert(Member member);
    int update(Member member);
    int delete(int no);
}
