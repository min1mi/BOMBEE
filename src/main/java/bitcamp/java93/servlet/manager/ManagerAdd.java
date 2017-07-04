package bitcamp.java93.servlet.manager;
/* ServletContext 보관소에 저장된 TeacherDao 이용하기
 */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java93.domain.Manager;
import bitcamp.java93.service.ManagerService;

@WebServlet(urlPatterns="/Manager/ManagerAdd")
public class ManagerAdd extends HttpServlet {
  private static final long serialVersionUID = 1L;

  // 다음 메서드는 Servlet 인터페이스에 선언된 메서드가 아니라,
  // HttpServlet클래스에 추가된 메서드이다.
  // 오리지날 service()가 호출되고 그 service()가 호출하는 메서드가 아래의 service()메서드이다.
  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    Manager mr = new Manager();
    mr.setName(req.getParameter("name"));
    mr.setTel(req.getParameter("tel"));
    mr.setEmail(req.getParameter("email"));
    mr.setPosition(req.getParameter("posi"));
    mr.setFax(req.getParameter("fax"));
    mr.setPath(req.getParameter("path"));

    try {
      ManagerService managerService = (ManagerService)this.getServletContext().getAttribute("managerService");
      managerService.add(mr);

      res.sendRedirect("MemberList");

    } catch (Exception e) {
      req.setAttribute("error", e); // ServletRequest 보관소에 오류 정보를 보관한다.
      RequestDispatcher rd = req.getRequestDispatcher("/error");
      rd.forward(req, res);
      return;
    }
  }
}












//
