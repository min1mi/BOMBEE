package bitcamp.java93.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.java93.dao.FriendDao;
import bitcamp.java93.domain.Friend;
import bitcamp.java93.service.FriendService;

@Service
public  class FriendServiceImpl implements FriendService {
  @Autowired
  FriendDao friendDao;

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
  public void detail(Friend friend) throws Exception {
    friendDao.detail(friend);
  }
  public Friend get2(int mno, int tno) throws Exception {
    return friendDao.selectOne(mno, tno);
  }
  @Override
  public List<Friend> addList(int no) throws Exception {
    return friendDao.addList(no);
  }
  @Override
  public int friendDelete(int no, int mno) throws Exception { //친구 신청 거부했을때 프로모션신청거부했을떄임
    friendDao.friendDelete(no, mno);
    return 1;// 성공시 1반환
  }

  

}