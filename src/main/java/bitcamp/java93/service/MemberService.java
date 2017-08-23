package bitcamp.java93.service;

import bitcamp.java93.domain.Member;

public interface MemberService {
  /*read-only : list, get*/
  void add(Member member) throws Exception;
  Member get(int no) throws Exception;
  Member getByEmailPassword(String id, String pwd) throws Exception;
  void profileUpdate(Member member) throws Exception;
}
