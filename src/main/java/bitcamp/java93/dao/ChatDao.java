package bitcamp.java93.dao;

import java.util.List;

import bitcamp.java93.domain.Chat;

public interface ChatDao {
  List<Chat> selectAll(int no);
  int insert(Chat chat);
  int delete(int no);
}
