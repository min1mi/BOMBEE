package bitcamp.java93.control.json;
/* ServletContext 보관소에 저장된 MemberDao 이용하기
 */

import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java93.domain.Member;
import bitcamp.java93.service.MemberService;

@RestController
@RequestMapping("/member/")
public class MemberControl {
  @Autowired
  ServletContext servletContext; // 서블릿 컨텍스트는 아규먼트로 받을 수 없기 때문에, IoC 컨테이너에게서 주입받는다.

  @Autowired
  MemberService memberService;

  @RequestMapping("list")
  public JsonResult list(@RequestParam(defaultValue="1") int pageNo,
                     @RequestParam(defaultValue="10") int pageSize) throws Exception {
    HashMap<String, Object> dataMap = new HashMap<>();
    dataMap.put("list", memberService.list(pageNo, pageSize));
    dataMap.put("totalCount", memberService.getSize());
    return new JsonResult(JsonResult.SUCCESS, dataMap);
  }

  @RequestMapping("add")
  public JsonResult add(Member member) throws Exception {
    memberService.add(member);
   return new JsonResult(JsonResult.SUCCESS, "ok");
  }

  @RequestMapping("update")
  public JsonResult update(Member member) throws Exception {
    memberService.update(member);
   return new JsonResult(JsonResult.SUCCESS, "ok");
  }

  @RequestMapping("detail")
  public JsonResult detail(int no, Model model) throws Exception {
      Member member = memberService.get(no);
      if (member == null) {
      return new JsonResult(JsonResult.FAIL, no + "번 회원이 없습니다.");
      }
      model.addAttribute("member", member);
      return new JsonResult(JsonResult.SUCCESS, member);
      // 예외 처리는 DispatcherServlet(frontcontroller)에게 맡긴다.
  }

  @RequestMapping("delete")
  public JsonResult delete(int no) throws Exception {
    memberService.remove(no);
   return new JsonResult(JsonResult.SUCCESS, "ok");
  }

}






















//
