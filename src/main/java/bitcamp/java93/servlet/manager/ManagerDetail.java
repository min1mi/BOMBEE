package bitcamp.java93.servlet.manager;
/* ServletContext 보관소에 저장된 TeacherDao 이용하기
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

@WebServlet(urlPatterns="/Manager/ManagerDetail")
public class ManagerDetail extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    res.setContentType("text/html;charset=UTF-8"); // 위에 정의해주기때문에 아래 <meta> 는 안해줘도 된다.
    PrintWriter out = res.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>회원 관리</title>");

 // including 기법을 사용하여 각 페이지에 기본 CSS 스타일 코드를 출력한다.
    RequestDispatcher rd = req.getRequestDispatcher("/Style/core");
    rd.include(req, res);

    out.println("</head>");
    out.println("<body>");

    rd = req.getRequestDispatcher("/header");
    rd.include(req, res);

    out.println("<h1>회원 조회</h1>");

    try {
      ManagerService managerService = (ManagerService)this.getServletContext().getAttribute("managerService");
      int no = Integer.parseInt(req.getParameter("no"));

      Manager manager = managerService.get(no);
      if (manager == null) {
        throw new Exception(no + "번 회원이 없습니다.");
      }

      out.println("<form action='TeacherUpdate' method='POST'>\n");
      out.printf("번호: <input type='text' name='no' value='%s' readonly><br>\n", manager.getNo());
      out.printf("이름: <input type='text' name='name' value='%s'><br>\n", manager.getName());
      out.printf("전화: <input type='text' name='tel' value='%s'><br>\n", manager.getTel());
      out.printf("이메일: <input type='text' name='email' value='%s'><br>\n", manager.getEmail());
      out.printf("직급: <input type='text' name='posi' value='%s'><br>\n", manager.getPosition());
      out.printf("팩스: <input type='text' name='fax' value='%s'><br>\n", manager.getFax());
      out.printf("사진경로: <input type='text' name='path' value='%s'><br>\n", manager.getPath());
      out.printf("암호: <input type='password' name='password'><br>\n");
      out.println("<button>변경</button>");
      out.println("<button type='button' onclick='doDelete()'>삭제</button>");
      out.println("<button type='button' onclick='doList()'>목록</button>");
      out.println("</form>");

      out.println("<script>");
      out.println("function doDelete() {");
      out.printf("  location.href='ManagerDelete?no=%s'\n", req.getParameter("no"));
      out.println("}");

      out.println("function doList() {");
      out.println("  location.href='ManagerList'");
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
