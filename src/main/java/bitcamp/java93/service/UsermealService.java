package bitcamp.java93.service;

import java.util.List;

import bitcamp.java93.domain.Usermeal;
import bitcamp.java93.domain.usermealList;

public interface UsermealService {
  /*read-only : list, get*/
  List<Usermeal> list(String startDate, String endDate, int trainingNo) throws Exception;
  usermealList getName(int trainingNo) throws Exception;
  void add(Usermeal usermeal) throws Exception;
  void update(Usermeal usermeal) throws Exception;
  void nopicUpdate(Usermeal usermeal) throws Exception;
  void confirm(int mealno) throws Exception;
  void remove(int mealno) throws Exception;
  List<Usermeal> traingList(int no) throws Exception;
  List<Usermeal> usersList(int no) throws Exception;
}
