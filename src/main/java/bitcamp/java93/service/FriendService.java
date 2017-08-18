package bitcamp.java93.service;

import bitcamp.java93.domain.Friend;
import bitcamp.java93.domain.Trainer;

public interface FriendService {
  /*read-only : list, get*/


  Friend get2(int mno, int tno) throws Exception;
  void add(Friend friend) throws Exception;
  void remove(Friend friend) throws Exception;
  void add2(Friend friend) throws Exception;
  void remove2(Friend friend) throws Exception;
  void detail(Friend friend) throws Exception;

}
