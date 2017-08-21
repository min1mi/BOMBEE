package bitcamp.java93.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.java93.dao.MemberDao;
import bitcamp.java93.dao.ScheduleDao;
import bitcamp.java93.domain.Schedule;
import bitcamp.java93.domain.Trainer;
import bitcamp.java93.service.ScheduleService;

@Service
public  class ScheduleServiceImpl implements ScheduleService {
  @Autowired
  ScheduleDao scheduleDao;
  @Autowired
  MemberDao memberDao;

  

  
  
  public Schedule get(int no) throws Exception {
    return scheduleDao.selectOne(no);
  }
  public void insert(Schedule schedule) throws Exception {
    scheduleDao.insert(schedule);

  }
  
  public void remove(int no) throws Exception {
//    int count = scheduleDao.delete(no);
//    if (count < 1) {
//      throw new Exception(no + "번 식단을 찾을 수 없습니다.");
//    }
    scheduleDao.delete(no);
//    try {
//      count = scheduleDao.delete(no);
//    } catch(Exception e) {}
  }
  @Override
  public List<Schedule> tcherSelectSchedule(int no, String day) throws Exception {
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("no", no);
    dataMap.put("day", day);
    return scheduleDao.tcherSelectSchedule(dataMap);
  }

  
}







