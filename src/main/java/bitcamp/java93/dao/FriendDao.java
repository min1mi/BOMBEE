package bitcamp.java93.dao;

import java.util.HashMap;
import java.util.List;

import bitcamp.java93.domain.Friend;
public interface FriendDao {

  int insert(Friend friend);
  int delete(Friend friend);
  int insert2(Friend friend);
  int delete2(Friend friend);
  Friend detail(Friend friend);
  Friend detail2(Friend friend);
  Friend detail3(Friend friend);
  Friend selectOne(int mno, int tno);
  List<Friend> addList(int no);
  List<Friend> addMlist(int no);
  void friendDelete(int no);
  int addReq(Friend friend);
  void friendUpdate(Friend friend);
  void addAlert(Friend friend);
}
