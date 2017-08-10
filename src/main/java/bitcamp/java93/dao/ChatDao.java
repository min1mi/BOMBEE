package bitcamp.java93.dao;

import java.util.List;
import java.util.Map;

import bitcamp.java93.domain.Chat;
import bitcamp.java93.domain.Usermeal;

public interface ChatDao {
  List<Chat> selectAll(int no);
  int insert(Usermeal usermeal);
  int delete(int mealno);
}
