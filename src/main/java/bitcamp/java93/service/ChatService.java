package bitcamp.java93.service;

import java.util.List;

import bitcamp.java93.domain.Chat;


public interface ChatService {
  /*read-only : list, get*/
  List<Chat> list(int no) throws Exception;
}
