package bitcamp.java93.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.java93.dao.MemberDao;
import bitcamp.java93.domain.Member;
import bitcamp.java93.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
  @Autowired
  MemberDao memberDao;

  public void add(Member member) throws Exception {
    memberDao.insert(member);
  }
  
  @Override
  public Member getByEmailPassword(String id, String pwd) throws Exception {
    HashMap<String,Object> valueMap = new HashMap<>();
    valueMap.put("id", id);
    valueMap.put("pwd", pwd);
    System.out.println("ddd"+valueMap);
    System.out.println(memberDao.selectOneByEmailPassword(valueMap));
    return memberDao.selectOneByEmailPassword(valueMap);
  }
  
}







