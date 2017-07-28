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
  public Trainer getByEmailPassword(String email, String password, int membertype) throws Exception {
    HashMap<String,Object> valueMap = new HashMap<>();
    valueMap.put("email", email);
    valueMap.put("password", password);
    valueMap.put("membertype", membertype);
    
    return trainerDao.selectOneByEmailPassword(valueMap);
  }
  
}







