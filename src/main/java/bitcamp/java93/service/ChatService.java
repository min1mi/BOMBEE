package bitcamp.java93.service;

import java.util.List;

import bitcamp.java93.domain.Usermeal;

public interface ChatService {
  /*read-only : list, get*/
  List<Usermeal> list(int no) throws Exception;
}
