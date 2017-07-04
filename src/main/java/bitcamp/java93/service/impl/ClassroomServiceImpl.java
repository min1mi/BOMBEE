package bitcamp.java93.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.java93.dao.ClassroomDao;
import bitcamp.java93.domain.Classroom;
import bitcamp.java93.service.ClassroomService;

@Service
public class ClassroomServiceImpl implements ClassroomService {
  @Autowired
  ClassroomDao classroomDao;


  public List<Classroom> list() throws Exception {
   return classroomDao.selectList();
  }

  public void add(Classroom classroom) throws Exception {
    classroomDao.insert(classroom);
  }

  public void update(Classroom classroom) throws Exception {
    int count = classroomDao.update(classroom);
    if (count < 1) {
      throw new Exception(classroom.getNo() + "번 강사를 찾을 수 없습니다.");
    }
  }

  public void remove(int no) throws Exception {
    int count = classroomDao.delete(no);
    if (count < 1) {
      throw new Exception(no + "번 강사를 찾을 수 없습니다.");
    }
  }
}
