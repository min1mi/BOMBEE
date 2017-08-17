package bitcamp.java93.dao;

import bitcamp.java93.domain.Friend;
public interface FriendDao {
  
  int insert(Friend friend);
  Friend selectOne(int no);
}
