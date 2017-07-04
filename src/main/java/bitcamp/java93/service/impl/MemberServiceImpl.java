package bitcamp.java93.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.java93.dao.MemberDao;
import bitcamp.java93.domain.Member;
import bitcamp.java93.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
  @Autowired
  MemberDao memberDao;

  public List<Member> list(int pageNo, int pageSize) throws Exception {
    HashMap<String,Object> valueMap = new HashMap<>();
    valueMap.put("startIndex", (pageNo - 1)  * pageSize);
    valueMap.put("pageSize", pageSize);
   return memberDao.selectList(valueMap);
  }

  public Member getByEmailPassword(String email, String password) throws Exception {
    HashMap<String,Object> valueMap = new HashMap<>();
    valueMap.put("email", email);
    valueMap.put("password", password);
    return memberDao.selectOneByEmailPassword(valueMap);
  }
  public Member get(int no) throws Exception {
    return memberDao.selectOne(no);
  }

  @Override
  public int getSize() throws Exception {
    return memberDao.countAll();
  }
  
  public void add(Member member) throws Exception {
    memberDao.insert(member);
  }

  public void update(Member member) throws Exception {
    int count = memberDao.update(member);
    if (count < 1) {
      throw new Exception(member.getNo() + "번 학생을 찾을 수 없습니다.");
    }

    count = memberDao.update(member);
    if (count < 1) {
      throw new Exception(member.getNo() + "번 학생을 찾을 수 없습니다.");
    }
  }

  public void remove(int no) throws Exception {
    int count = memberDao.delete(no);
    if (count < 1) {
      throw new Exception(no + "번 학생을 찾을 수 없습니다.");
    }

    try {
      count = memberDao.delete(no);
    } catch(Exception e) {}
  }
}
