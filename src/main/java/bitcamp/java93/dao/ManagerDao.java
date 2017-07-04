package bitcamp.java93.dao;


import java.util.List;

import bitcamp.java93.domain.Manager;

public interface ManagerDao {
  List<Manager> selectNameList() throws Exception;
  List<Manager> selectList(int pageNo, int pageSize) throws Exception;
  Manager selectOne(int no) throws Exception;
  int insert(Manager manager) throws Exception;
  int delete(int no) throws Exception;
  int update(Manager manager) throws Exception;
}
