package bitcamp.java93.dao;

import bitcamp.java93.domain.Schedule;

public interface ScheduleDao {
  
  Schedule selectOne(int no);
  int insert(Schedule Schedule);
  int delete(int no);
}
