package bitcamp.java93.service;

import java.util.List;

import bitcamp.java93.domain.Member;

public interface MemberService {
  List<Member> list(int pageNo, int pageSize) throws Exception;
  Member getByEmailPassword(String email, String password) throws Exception;
  Member get(int no) throws Exception;
  int getSize() throws Exception;
  void add(Member member) throws Exception;
  void update(Member member) throws Exception;
  void remove(int no) throws Exception;
}
