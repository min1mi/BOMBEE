package bitcamp.java93.control;
/* ServletContext 보관소에 저장된 MemberDao 이용하기
 */

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.java93.domain.Member;
import bitcamp.java93.service.MemberService;

@Controller
@RequestMapping("/member/")
public class MemberControl {
  @Autowired
  ServletContext servletContext; // 서블릿 컨텍스트는 아규먼트로 받을 수 없기 때문에, IoC 컨테이너에게서 주입받는다.

  @Autowired
  MemberService memberService;

  @RequestMapping("list")
  public String list(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="10") int pageSize,
      Model model) throws Exception {
    model.addAttribute("list", memberService.list(pageNo, pageSize));
    return "member/list";
  }

  @RequestMapping("add")
  public String add(Member member) throws Exception {
    memberService.add(member);
    return "redirect:list.do";
  }

  @RequestMapping("update")
  public String update(Member member) throws Exception {
    memberService.update(member);
    return "redirect:list.do";
  }

  @RequestMapping("detail")
  public String detail(int no, Model model) throws Exception {
      Member member = memberService.get(no);
      if (member == null) {
        throw new Exception(no + "번 회원이 없습니다.");
      }
      model.addAttribute("member", member);
      return "teacher/detail";
      // 예외 처리는 DispatcherServlet(frontcontroller)에게 맡긴다.
  }

  @RequestMapping("delete")
  public String delete(int no) throws Exception {
    memberService.remove(no);
    return "redirect:list.do";
  }

}






















//
