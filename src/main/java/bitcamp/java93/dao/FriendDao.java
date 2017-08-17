package bitcamp.java93.dao;

import bitcamp.java93.domain.Friend;
import bitcamp.java93.domain.Trainer;
public interface FriendDao {

  int get(Friend friend);
  int insert(Friend friend);
  int delete(Friend friend);
  int insert2(Friend friend);
  int delete2(Friend friend);
}
