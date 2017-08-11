package bitcamp.java93.dao;

import java.util.List;
import java.util.Map;

import bitcamp.java93.domain.Usermeal;

public interface UsermealDao {
  List<Usermeal> selectWeeklist(Map<String,Object> valueMap);
  int insert(Usermeal usermeal);
  int update(Usermeal usermeal);
  int nopicUpdate(Usermeal usermeal);
  int delete(int mealno);
}
