package bitcamp.java93.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.java93.dao.UsermealDao;
import bitcamp.java93.domain.Usermeal;
import bitcamp.java93.service.UsermealService;

@Service
public class UsermealServiceImpl implements UsermealService {
  @Autowired
  UsermealDao usermealDao;
  
  public List<Usermeal> list(String startDate, String endDate) throws Exception {
    HashMap<String,Object> valueMap = new HashMap<>();
    valueMap.put("startDate", startDate);
    valueMap.put("endDate", endDate);
    
    return usermealDao.selectWeeklist(valueMap);
  }

  public void add(Usermeal usermeal) throws Exception {
    usermealDao.insert(usermeal);
  }

  @Override
  public void update(Usermeal usermeal) throws Exception {
    usermealDao.update(usermeal);
  }
  
}







