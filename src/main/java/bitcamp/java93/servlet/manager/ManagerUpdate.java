package bitcamp.java93.servlet.manager;
/* ServletContext 보관소에 저장된 ManagerDao 이용하기
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java93.domain.Manager;
import bitcamp.java93.service.ManagerService;

@WebServlet(urlPatterns="/Manager/ManagerUpdate")
public class ManagerUpdate extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    Manager mr = new Manager();
    mr.setNo(Integer.parseInt(req.getParameter("no")));
    mr.setName(req.getParameter("name"));
    mr.setTel(req.getParameter("tel"));
    mr.setEmail(req.getParameter("email"));
    mr.setPosition(req.getParameter("posi"));
    mr.setFax(req.getParameter("fax"));
    mr.setPath(req.getParameter("path"));
    // 이렇게 출력 스트림을 얻기 전에 먼저 호출해야 한다.
    res.setContentType("text/html;charset=UTF-8"); // 위에 정의해주기때문에 아래 <meta> 는 안해줘도 된다.
    PrintWriter out = res.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>강사 관리</title>");

 // including 기법을 사용하여 각 페이지에 기본 CSS 스타일 코드를 출력한다.
    RequestDispatcher rd = req.getRequestDispatcher("/Style/core");
    rd.include(req, res);

    out.println("</head>");
    out.println("<body>");
    out.println("<h1>강사 변경</h1>");

    try {
      ManagerService managerService = (ManagerService)this.getServletContext().getAttribute("managerService");
      managerService.update(mr);

      out.println("<p>변경 성공입니다.</p>");

      // 버퍼의 내용물이 클라이언트에게 전달되기 전이라면
      // 언제든지 다음과 같이 헤더를 추가하거나 변경할 수 있다.
      res.setHeader("Refresh", "1;url=ManagerList");

    } catch (Exception e) {
      // 예외 객체 e 를 error라는 이름으로 담는다.
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
