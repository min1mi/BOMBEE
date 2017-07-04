package bitcamp.java93.service;

import java.util.List;

import bitcamp.java93.domain.Manager;

public interface ManagerService {
  List<Manager> list(int pageNo, int pageSize) throws Exception;
  List<Manager> nameList() throws Exception;
  Manager get(int no) throws Exception;
  void add(Manager manager) throws Exception ;
  void update(Manager manager) throws Exception;
  void remove(int no) throws Exception;
}
