package bitcamp.java93.control.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java93.domain.Member;
import bitcamp.java93.service.MemberService;

@RestController
@RequestMapping("/member/")
public class MemberControl {
  @Autowired
  MemberService memberService;
  
  @RequestMapping("add")
  public JsonResult add(Member member) throws Exception {
    System.out.println("imcoming");
    memberService.add(member);
    System.out.println("datacoming");
    return new JsonResult(JsonResult.SUCCESS, "ok");
  }
}
