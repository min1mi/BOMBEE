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

import bitcamp.java93.domain.Classroom;

public interface ClassroomDao {
  List<Classroom> selectList() throws Exception;
  public int insert(Classroom classroom) throws Exception;
  public int delete(int no) throws Exception;
  public int update(Classroom classroom) throws Exception;
 
/*
  public Classroom selectOne(int no) throws Exception {
    Connection con = conPool.getConnection();

    try (
        PreparedStatement stmt = con.prepareStatement(
            "select mno, name, tel, email from memb where mno=?");) {

      stmt.setInt(1, no);

      try (ResultSet rs = stmt.executeQuery();) {
        if (!rs.next()) {
          return null;
        }

        Classroom classroom = new Classroom();
        classroom.setNo(rs.getInt("mno"));
        classroom.setName(rs.getString("name"));
        classroom.setTel(rs.getString("tel"));
        classroom.setEmail(rs.getString("email"));
        return classroom;
      }

    } finally { // 다 쓴 커넥션을 반납하기 위해서
      // finally 블록은 try 블록을 벗어나기 전에 반드시 실행되는 블록이다.
      // try 블록에서 return 문을 실행하기 전에 이 블록을 실행한다.
      conPool.returnConnection(con);
    }
  } // selectOne
*/
}
