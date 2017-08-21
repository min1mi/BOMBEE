package bitcamp.java93.dao;

import java.util.HashMap;
import java.util.List;

import bitcamp.java93.domain.Schedule;

public interface ScheduleDao {
  
  Schedule selectOne(int no);
  int insert(Schedule Schedule);
  int delete(int no);
  List<Schedule> tcherSelectSchedule(HashMap<String,Object> dataMap);
}
