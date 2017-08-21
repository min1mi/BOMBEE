package bitcamp.java93.service;

import java.util.List;

import bitcamp.java93.domain.Schedule;
import bitcamp.java93.domain.Trainer;

public interface ScheduleService {
  /*read-only : list, get*/
  
  
  Schedule get(int no) throws Exception;
  void insert(Schedule schedule) throws Exception;
  void remove(int no) throws Exception;
  List<Schedule> tcherSelectSchedule(int no, String day) throws Exception;
  
}
