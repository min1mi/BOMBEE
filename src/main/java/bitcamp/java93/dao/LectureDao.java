package bitcamp.java93.dao;
/* 역할:
 * => memb 테이블의 데이터를 다루는 메서드를 모아둔 클래스이다.
 * => 출력하는 역할은 호출자에게 맡긴다.
 * => DAO의 역할은 결과를 리턴하면 된다.
 * => 커넥션은 DBConnectionPool로부터 얻어서 사용하고,
 *    사용한 후에는 반납한다.
 * => DAO는 커넥션을 관리하지 않는다.
 */


import java.util.List;

import bitcamp.java93.domain.Lecture;

public interface LectureDao {
  List<Lecture> selectList(int pageNo, int pageSize) throws Exception;
  Lecture selectOne(int no) throws Exception;
  int insert(Lecture lecture) throws Exception;
  int delete(int no) throws Exception;
  int update(Lecture lecture) throws Exception ;
}














//