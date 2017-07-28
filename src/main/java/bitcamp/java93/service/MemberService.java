package bitcamp.java93.service;

import bitcamp.java93.domain.Member;

public interface MemberService {
  /*read-only : list, get*/
  void add(Member member) throws Exception;
  Member getByEmailPassword(String email, String password, int membertype) throws Exception;
}
