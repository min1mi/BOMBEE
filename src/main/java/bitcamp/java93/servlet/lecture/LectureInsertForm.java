package bitcamp.java93.servlet.lecture;
/* 게시글 등록하기
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import bitcamp.java93.domain.Classroom;
import bitcamp.java93.domain.Manager;
import bitcamp.java93.service.ClassroomService;
import bitcamp.java93.service.ManagerService;

@WebServlet(urlPatterns="/Lecture/LectureInsertForm")
public class LectureInsertForm extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    // 이렇게 출력 스트림을 얻기 전에 먼저 호출해야 한다.
    res.setContentType("text/html;charset=UTF-8"); // 위에 정의해주기때문에 아래 <meta> 는 안해줘도 된다.
    PrintWriter out = res.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>강의 관리</title>");

    // including 기법을 사용하여 각 페이지에 기본 CSS 스타일 코드를 출력한다.
    RequestDispatcher rd = req.getRequestDispatcher("/Style/core");
    rd.include(req, res);

    out.println("</head>");
    out.println("<body>");
    
    rd = req.getRequestDispatcher("/header");
    rd.include(req, res);
    
    
    out.println("<div class='container'>");
    out.println("<h1>강의 등록</h1>");

    try {
      ClassroomService classroomService = (ClassroomService)this.getServletContext().getAttribute("classroomService");
      ManagerService managerService = (ManagerService)this.getServletContext().getAttribute("managerService");

      List<Classroom> classroomList = classroomService.list();

      List<Manager> managerList = managerService.nameList();

      out.println("<form class='form-horizontal' action='LectureInsert' method='POST'>\n");
      out.println("<div class='form-group'>");
      out.println("<label class='col-sm-3 control-label'>번호</label>");
      out.println("<div class='col-sm-7'>");
      out.printf("<input type='text' class='form-control' name='lno' readonly></div></div>\n");
      out.println("<div class='form-group'>");
      out.println("<label class='col-sm-3 control-label'>강의명</label>");
      out.println("<div class='col-sm-7'>");
      out.printf("<input type='text' class='form-control' name='titl'></div></div>\n");
      out.println("<div class='form-group'>");
      out.println("<label class='col-sm-3 control-label'>설명</label>");
      out.println("<div class='col-sm-4'>");
      out.printf("<textarea class='form-control' name='dscp'></textarea></div></div>\n");
      out.println("<div class='form-group'>");
      out.println("<label class='col-sm-3 control-label'>시작일</label>");
      out.println("<div class='col-sm-4'>");
      out.printf("<input type='date' class='form-control' name='sdt'></div></div>\n");
      out.println("<div class='form-group'>");
      out.println("<label class='col-sm-3 control-label'>종료일</label>");
      out.println("<div class='col-sm-4'>");
      out.printf("<input type='date' class='form-control' name='edt'></div></div>\n");
      out.println("<div class='form-group'>");
      out.println("<label class='col-sm-3 control-label'>수강가능인원</label>");
      out.println("<div class='col-sm-4'>");
      out.printf("<input type='test' class='form-control' name='qty'></div></div>\n");
      out.println("<div class='form-group'>");
      out.println("<label class='col-sm-3 control-label'>수업료</label>");
      out.println("<div class='col-sm-4'>");
      out.printf("<input type='text' class='form-control' name='pric'></div></div>\n");
      out.println("<div class='form-group'>");
      out.println("<label class='col-sm-3 control-label'>총시간</label>");
      out.println("<div class='col-sm-4'>");
      out.printf("<input type='text' class='form-control' name='thrs'></div></div>\n");
      out.println("<div class='form-group'>");
      out.println("<label class='col-sm-3 control-label'>강의실</label>");
      out.println("<div class='col-sm-4'>");
      out.println("<select class='form-control' name='crmno'><option value='0'>강의실을 선택하세요</option>");
      for (Classroom c : classroomList) {
        out.printf("<option value='%d'>%s</option>\n", c.getNo(), c.getName());
      }
      out.println("</select></div></div>");
      out.println("<div class='form-group'>");
      out.println("<label class='col-sm-3 control-label'>매니저</label>");
      out.println("<div class='col-sm-4'>");
      out.println("<select class='form-control' name='mrno'><option value='0'>매니저를 선택하세요</option>");
      for (Manager m : managerList) {
        out.printf("<option value='%d'>%s</option>\n", m.getNo(), m.getName());
      }
      out.println("</select></div></div>");

      out.println("<div class='form-group'>");
      out.println("<div class='col-sm-offset-2 col-sm-10'>");
      out.println("<button class='btn btn-primary'>등록</button>");
      out.println("<button type='button' class='btn btn-primary' onclick='doList()'>목록</button></div></div>");
      out.println("</form>");
      out.println("</div>");

      out.println("<script>");
      out.println("function doList() {");
      out.println("  location.href='LectureList'");
      out.println("}");
      out.println("</script>");

    } catch (Exception e) {
      req.setAttribute("error", e); // ServletRequest 보관소에 오류 정보를 보관한다.
      rd = req.getRequestDispatcher("/error");
      rd.forward(req, res);
      return;
    }

 // including 기법을 사용하여 각 페이지마다 꼬리말을 붙인다.
    rd = req.getRequestDispatcher("/footer");
    rd.include(req, res);

    out.println("</body>");
    out.println("</html>");
  }
}












//
