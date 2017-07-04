package bitcamp.java93.dao.mysql;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java93.dao.ManagerDao;
import bitcamp.java93.domain.Manager;
import bitcamp.java93.util.DBConnectionPool;

@Component
public class ManagerDaoImpl implements ManagerDao{
  @Autowired
  DBConnectionPool conPool;

  public List<Manager> selectNameList() throws Exception {
    Connection con = conPool.getConnection();

    try (
        PreparedStatement stmt = con.prepareStatement(
            "select mr.mrno, m.name"
            + " from mgr mr inner join memb m on mr.mrno=m.mno"
            + " order by m.name asc");) {

      
      ArrayList<Manager> list = new ArrayList<>();
      try (ResultSet rs = stmt.executeQuery();) {
        Manager manager = null;
        while (rs.next()) {
          manager = new Manager();
          manager.setNo(rs.getInt("mrno"));
          manager.setName(rs.getString("name"));

          list.add(manager);
        }
      }
      return list;

    } finally { // 다 쓴 커넥션을 반납하기 위해서
      // finally 블록은 try 블록을 벗어나기 전에 반드시 실행되는 블록이다.
      // try 블록에서 return 문을 실행하기 전에 이 블록을 실행한다.
      conPool.returnConnection(con);
    }
  }
  
  public List<Manager> selectList(int pageNo, int pageSize) throws Exception {
    // 사용할 커넥션을 DBConnectionPool로부터 빌린다.
    Connection con = conPool.getConnection();

    try (
        PreparedStatement stmt = con.prepareStatement(
            "select mr.mrno, m.name"
            + " from mgr mr inner join memb m on mr.mrno=m.mno"
            + " order by m.name asc limit ?, ?");) {

      stmt.setInt(1, (pageNo - 1) * pageSize/* 시작 인덱스 */);
      stmt.setInt(2, pageSize/* 꺼낼 레코드 수 */);
      
      ArrayList<Manager> list = new ArrayList<>();
      try (ResultSet rs = stmt.executeQuery();) {
        Manager manager = null;
        while (rs.next()) {
          manager = new Manager();
          manager.setNo(rs.getInt("mrno"));
          manager.setName(rs.getString("name"));

          list.add(manager);
        }
      }
      return list;

    } finally { // 다 쓴 커넥션을 반납하기 위해서
      // finally 블록은 try 블록을 벗어나기 전에 반드시 실행되는 블록이다.
      // try 블록에서 return 문을 실행하기 전에 이 블록을 실행한다.
      conPool.returnConnection(con);
    }
  }

  public Manager selectOne(int no) throws Exception {
    Connection con = conPool.getConnection();

    try (
        PreparedStatement stmt = con.prepareStatement(
            "select mr.mrno, m.name"
            + " from mgr mr inner join memb m on mr.mrno=m.mno"
            + " order by m.name asc");) {

      stmt.setInt(1, no);

      try (ResultSet rs = stmt.executeQuery();) {
        if (!rs.next()) {
          return null;
        }

        Manager manager = new Manager();
        manager.setNo(rs.getInt("mrno"));
        manager.setName(rs.getString("name"));
        return manager;
      }

    } finally { // 다 쓴 커넥션을 반납하기 위해서
      // finally 블록은 try 블록을 벗어나기 전에 반드시 실행되는 블록이다.
      // try 블록에서 return 문을 실행하기 전에 이 블록을 실행한다.
      conPool.returnConnection(con);
    }
  }

  public int insert(Manager manager) throws Exception {
    Connection con = conPool.getConnection();
    try (
        PreparedStatement stmt = con.prepareStatement(
            "insert into mgr(mrno, posi, fax, path) values(?, ?, ?, ?)");
        ) {
      stmt.setInt(1, manager.getNo());
      stmt.setString(2, manager.getPosition());
      stmt.setString(3, manager.getFax());
      stmt.setString(4, manager.getPath());
      return stmt.executeUpdate();
    }finally {
      conPool.returnConnection(con);
    }
  }

  public int delete(int no) throws Exception {
    Connection con = conPool.getConnection();
    try (
        PreparedStatement stmt = con.prepareStatement(
            "delete from mgr where mrno=?");
        ) {

      stmt.setInt(1, no);
      return stmt.executeUpdate();

    } finally {
      conPool.returnConnection(con);
    }
  }

  public int update(Manager manager) throws Exception {
    Connection con = conPool.getConnection();
    try (
        PreparedStatement stmt = con.prepareStatement(
            "update mgr set posi=?, fax=?, path=? where mrno=?");
        ) {
      stmt.setString(1, manager.getPosition());
      stmt.setString(2, manager.getFax());
      stmt.setString(3, manager.getPath());
      stmt.setInt(4, manager.getNo());
      return stmt.executeUpdate();
    } finally {
      conPool.returnConnection(con);
    }
  }
}
