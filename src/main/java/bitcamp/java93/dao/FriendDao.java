package bitcamp.java93.dao;

import java.util.HashMap;

import bitcamp.java93.domain.Friend;
import bitcamp.java93.domain.Trainer;
public interface FriendDao {

  int insert(Friend friend);
  int delete(Friend friend);
  int insert2(Friend friend);
  int delete2(Friend friend);
  int detail(Friend friend);
  Friend selectOne(int mno, int tno);

}
