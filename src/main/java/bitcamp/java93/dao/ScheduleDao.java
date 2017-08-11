package bitcamp.java93.dao;

import java.sql.Time;

import bitcamp.java93.domain.Schedule;
import bitcamp.java93.domain.Trainer;

public interface ScheduleDao {
  
  Schedule selectOne(int no);
  int insert(Schedule Schedule);
  int delete(int no);
}
