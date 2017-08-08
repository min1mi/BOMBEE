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
    memberService.add(member);
    return new JsonResult(JsonResult.SUCCESS, "ok");
  }
  
//  @RequestMapping("searchMusician")
//  public JsonResult searchMusician(HttpSession session, String location) throws Exception {
//    HashMap<String,Object> dataMap = new HashMap<>();
//    List<Musician> search= (List<Musician>)musicianService.searchMusician(getLoginMember(session).getNo() ,location);
//    dataMap.put("listSurf", search);
//    return new JsonResult(JsonResult.SUCCESS, dataMap);
//  }

}
