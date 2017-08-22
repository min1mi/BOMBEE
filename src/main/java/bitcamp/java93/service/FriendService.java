package bitcamp.java93.service;


import java.util.List;

import bitcamp.java93.domain.Friend;

public interface FriendService {
  /*read-only : list, get*/


  Friend get2(Friend friend) throws Exception;
  Friend get(Friend friend) throws Exception;
  void add(Friend friend) throws Exception;
  void remove(Friend friend) throws Exception;
  void add2(Friend friend) throws Exception;
  void remove2(Friend friend) throws Exception;
  List<Friend> addList(int no) throws Exception;
  int friendDelete(int no) throws Exception;
  int addReq(Friend friend) throws Exception;
  void friendUpdate(Friend friend) throws Exception;
  List<Friend> addMlist(int no) throws Exception;
}
