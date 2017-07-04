package bitcamp.java93.servlet.lecture;
/* 회원관리 만들기 : 회원등록하기
 * => MemberDao를 이용하여 클라이언트로부터 받은 회원 정보를 저장한다.
 */


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java93.domain.Lecture;
import bitcamp.java93.service.LectureService;

@WebServlet(urlPatterns="/Lecture/LectureInsert")
public class LectureInsert extends HttpServlet {
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

    try {
      LectureService lectureService = (LectureService)this.getServletContext().getAttribute("lectureService");
      lectureService.add(l);
      res.sendRedirect("LectureList");

    } catch (Exception e) {
      req.setAttribute("error", e); // ServletRequest 보관소에 오류 정보를 보관한다.
      RequestDispatcher rd = req.getRequestDispatcher("/error");
      rd.forward(req, res);
      return;
    }
  }
}












//
