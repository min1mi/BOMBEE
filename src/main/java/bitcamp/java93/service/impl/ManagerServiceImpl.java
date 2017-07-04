package bitcamp.java93.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.java93.dao.ManagerDao;
import bitcamp.java93.dao.MemberDao;
import bitcamp.java93.domain.Manager;
import bitcamp.java93.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {
  @Autowired
  MemberDao memberDao;
  @Autowired
  ManagerDao managerDao;

  public List<Manager> list(int pageNo, int pageSize) throws Exception {
   return managerDao.selectList(pageNo, pageSize);
  }
  
  public List<Manager> nameList() throws Exception {
    return managerDao.selectNameList();
  }

  public Manager get(int no) throws Exception {
    return managerDao.selectOne(no);
  }

  public void add(Manager manager) throws Exception {
    memberDao.insert(manager);
    managerDao.insert(manager);
  }

  public void update(Manager manager) throws Exception {
    int count = memberDao.update(manager);
    if (count < 1) {
      throw new Exception(manager.getNo() + "번 강사를 찾을 수 없습니다.");
    }

    count = managerDao.update(manager);
    if (count < 1) {
      throw new Exception(manager.getNo() + "번 강사를 찾을 수 없습니다.");
    }
  }

  public void remove(int no) throws Exception {
    int count = managerDao.delete(no);
    if (count < 1) {
      throw new Exception(no + "번 강사를 찾을 수 없습니다.");
    }

    try {
      count = memberDao.delete(no);
    } catch(Exception e) {}
  }
}
