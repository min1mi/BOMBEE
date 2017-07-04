package bitcamp.java93.servlet.lecture;
/* 게시판 List 출력
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java93.domain.Lecture;
import bitcamp.java93.service.LectureService;

@WebServlet(urlPatterns="/Lecture/LectureList")
public class LectureList extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    /* 페이지 번호와 페이지당 출력 개수 파라미터 받기 */
    int pageNo = 1;
    int pageSize = 5;

    try { // pageNo 파라미터 값이 있다면 그 값으로 설정한다.
      pageNo = Integer.parseInt(req.getParameter("pageNo"));
    } catch (Exception e) {}

    try { // pageSize 파라미터 값이 있다면 그 값으로 설정한다.
      pageSize = Integer.parseInt(req.getParameter("pageSize"));
    } catch (Exception e) {}

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
    out.println("<h1>강의 목록</h1>");

    try {
      LectureService lectureService = (LectureService)this.getServletContext().getAttribute("lectureService");
      List<Lecture> list = lectureService.list(pageNo, pageSize);

      out.println("<table class='table table-hover'>");
      out.println("<thead>");
      out.println("  <tr><th>번호</th><th>제목</th><th>시작일</th><th>종료일</th><th>강의시간</th><th>수업료</th></tr>");
      out.println("</thead>");
      out.println("<tbody>");
      for (Lecture l : list) {
        out.println("<tr>");
        out.printf("  <td>%d</td>\n", l.getLno());
        out.printf("  <td><a href='LectureView?no=%d'>%s</a></td>\n", l.getLno(), l.getTitle());
        out.printf("  <td>%s</td>\n", l.getStartDate());
        out.printf("  <td>%s</td>\n", l.getEndDate());
        out.printf("  <td>%s</td>\n", l.getTotalHours());
        out.printf("  <td>%s</td>\n", l.getPrice());
        out.println("</tr>");
      }
      out.println("</tbody>");
      out.println("</table>");
      out.println("<a href='LectureInsertForm' class='btn btn-primary'>추가</a>");
      out.println("</div>");
      
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
