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
 

  

  public Friend get(int no) throws Exception {
    return friendDao.selectOne(no);
  }
  public void add(Friend friend) throws Exception {
    friendDao.insert(friend);

  }

  
}







