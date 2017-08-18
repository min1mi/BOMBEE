package bitcamp.java93.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.java93.dao.MemberDao;
import bitcamp.java93.dao.TrainerDao;
import bitcamp.java93.domain.Trainer;
import bitcamp.java93.service.TrainerService;

@Service
public class TrainerServiceImpl implements TrainerService {
  @Autowired
  TrainerDao trainerDao;
  @Autowired
  MemberDao memberDao;

  public void add(Trainer trainer) throws Exception {
    memberDao.insert(trainer);
    trainerDao.insert(trainer);
  }

  @Override
  public Trainer getByEmailPassword(String id, String pwd) throws Exception {
    HashMap<String,Object> valueMap = new HashMap<>();
    valueMap.put("id", id);
    valueMap.put("pwd", pwd);
    System.out.println(valueMap);
    
    return trainerDao.selectOneByEmailPassword(valueMap);
  }
  
  public Trainer get(int no) throws Exception {
    return trainerDao.selectOne(no);
  }
  public Trainer get2(int no) throws Exception {
    return trainerDao.selectOne2(no);
  }
  public void update(Trainer trainer) throws Exception {
  trainerDao.update(trainer);

}
  
}







