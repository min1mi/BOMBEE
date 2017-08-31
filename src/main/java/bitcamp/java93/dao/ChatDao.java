package bitcamp.java93.dao;

import java.util.List;

import bitcamp.java93.domain.Chat;

public interface ChatDao {
  List<Chat> selectMemberAll(int no);
  List<Chat> selectTrainerAll(int no);
  int insert(Chat chat);
  int delete(int no);
  int memberChatStatus(int no);
  int trainerChatStatus(int no);
  int updateRead(Chat chat);
}
