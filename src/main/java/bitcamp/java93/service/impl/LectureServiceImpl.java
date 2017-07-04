package bitcamp.java93.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.java93.dao.ClassroomDao;
import bitcamp.java93.dao.LectureDao;
import bitcamp.java93.dao.ManagerDao;
import bitcamp.java93.domain.Lecture;
import bitcamp.java93.service.LectureService;

@Service
public class LectureServiceImpl implements LectureService {
  @Autowired
  LectureDao lectureDao;
  @Autowired
  ManagerDao managerDao;
  @Autowired
  ClassroomDao classroomDao;

  public List<Lecture> list(int pageNo, int pageSize) throws Exception {
   return lectureDao.selectList(pageNo, pageSize);
  }

  public Lecture get(int no) throws Exception {
    return lectureDao.selectOne(no);
  }

  public void add(Lecture lecture) throws Exception {
    lectureDao.insert(lecture);
  }

  public void update(Lecture lecture) throws Exception {
    int count = lectureDao.update(lecture);
    if (count < 1) {
      throw new Exception(lecture.getLno() + "번 강의실 찾을 수 없습니다.");
    }
  }

  public void remove(int no) throws Exception {
    int count = lectureDao.delete(no);
    if (count < 1) {
      throw new Exception(no + "번 강의실 찾을 수 없습니다.");
    }

    try {
      count = lectureDao.delete(no);
    } catch(Exception e) {}
  }
}
