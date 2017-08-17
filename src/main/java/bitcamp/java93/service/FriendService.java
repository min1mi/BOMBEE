package bitcamp.java93.service;

import bitcamp.java93.domain.Friend;
import bitcamp.java93.domain.Trainer;

public interface FriendService {
  /*read-only : list, get*/
  
  
  void add(Friend friend) throws Exception;
  Friend get(int no) throws Exception;
}
