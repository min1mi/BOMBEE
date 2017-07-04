package bitcamp.java93.service;

import java.util.List;

import bitcamp.java93.domain.Classroom;

public interface ClassroomService {
  List<Classroom> list() throws Exception;
  void add(Classroom classroom) throws Exception;
  void update(Classroom classroom) throws Exception;
  void remove(int no) throws Exception;
}
