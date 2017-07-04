package bitcamp.java93.servlet.lecture;
/* 게시글 변경하기
 */


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java93.domain.Lecture;
import bitcamp.java93.service.LectureService;

@WebServlet(urlPatterns="/Lecture/LectureUpdate")
public class LectureUpdate extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");

    Lecture l = new Lecture();
    l.setDscp(req.getParameter("dscp"));
    l.setStartDate(req.getParameter("sdt"));
    l.setEndDate(req.getParameter("edt"));
    l.setQty(Integer.parseInt(req.getParameter("qty")));
    l.setPrice(Integer.parseInt(req.getParameter("pric")));
    l.setTotalHours(Integer.parseInt(req.getParameter("thrs")));
    l.setTitle(req.getParameter("titl"));
    l.setCrmno(Integer.parseInt(req.getParameter("crmno")));
    l.setMrno(Integer.parseInt(req.getParameter("mrno")));
    l.setLno(Integer.parseInt(req.getParameter("lno")));


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
    
    
    out.println("<h1>강의 변경</h1>");

    try {
      LectureService lectureService = (LectureService)this.getServletContext().getAttribute("lectureService");
      lectureService.update(l);
      
      out.println("<p>변경 성공입니다.</p>");
      res.setHeader("Refresh", "1;url=LectureList");
      
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
