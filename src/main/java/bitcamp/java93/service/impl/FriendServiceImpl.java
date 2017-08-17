package bitcamp.java93.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.java93.dao.FriendDao;
import bitcamp.java93.domain.Friend;
import bitcamp.java93.service.FriendService;

@Service
public  class FriendServiceImpl implements FriendService {
  @Autowired
  FriendDao friendDao;

  
  public void get(Friend friend) throws Exception {
    friendDao.get(friend);
  }
  public void add(Friend friend) throws Exception {
    friendDao.insert(friend);
  }
  public void remove(Friend friend) throws Exception {
    friendDao.delete(friend);
  }
  public void add2(Friend friend) throws Exception {
    friendDao.insert2(friend);
  }
  public void remove2(Friend friend) throws Exception {
    friendDao.delete2(friend);
  }

}