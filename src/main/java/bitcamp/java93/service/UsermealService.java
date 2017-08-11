package bitcamp.java93.service;

import java.util.List;

import bitcamp.java93.domain.Usermeal;

public interface UsermealService {
  /*read-only : list, get*/
  List<Usermeal> list(String startDate, String endDate) throws Exception;
  void add(Usermeal usermeal) throws Exception;
  void update(Usermeal usermeal) throws Exception;
  void nopicUpdate(Usermeal usermeal) throws Exception;
  void remove(int mealno) throws Exception;
}
