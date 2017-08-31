package bitcamp.java93.service;

import java.util.List;

import bitcamp.java93.domain.Chat;


public interface ChatService {
  /*read-only : list, get*/
  List<Chat> memberlist(int no) throws Exception;
  List<Chat> trainerlist(int no) throws Exception;
  int memberChatStatus(int no) throws Exception;
  int trainerChatStatus(int no) throws Exception;
  int updateRead(Chat chat) throws Exception;
}
