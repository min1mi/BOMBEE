package bitcamp.java93.control.json;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import bitcamp.java93.domain.Member;
import bitcamp.java93.domain.Trainer;
import bitcamp.java93.service.MemberService;
import bitcamp.java93.service.TrainerService;

@RestController
@RequestMapping("/auth/")
@SessionAttributes({"loginMember"}) // model에 담긴 것 중에 loginMember라고 되어있는 애는 따로 Session에 보관하라. 
public class AuthControl {
  @Autowired
  TrainerService trainerService;
  @Autowired
  MemberService memberService;

  @RequestMapping(path="login", method=RequestMethod.POST) // POST 요청이 들어왔을 때 호출
  public JsonResult login(int membertype, String id, String pwd, 
     Model model, HttpSession session) throws Exception {
    System.out.println(membertype);
    Member member = null;
    Trainer trainer = null;

    if (membertype == 1) {
      //         studentService 객체를 사용하여 로그인 처리
      member = memberService.getByEmailPassword(id, pwd);
      System.out.println(member);

    } else if (membertype == 2) {
      trainer = trainerService.getByEmailPassword(id, pwd);
      System.out.println(trainer);
    }

    //      MemberService memberService = (MemberService)this.getServletContext().getAttribute("memberService");
    //      member = memberService.getByEmailPassword(email, password);

    if (member != null || trainer != null) { // 로그인에 성공했다면
      // HttpSession 보관소에 로그인 회원 정보를 저장한다.
      if (member != null ) {
        model.addAttribute("loginMember", member);
        
      } else if (trainer != null) {
        model.addAttribute("loginMember", trainer);
      }

      return new JsonResult(JsonResult.SUCCESS, "ok");

    } else {
      return new JsonResult(JsonResult.FAIL, "fail");
    }

  }
  @RequestMapping("logout")
  public JsonResult logout(HttpSession session, SessionStatus status) throws Exception {
    status.setComplete();
    session.invalidate(); // 요청한 클라이언트의 전용 HttpSession 객체를 무효화시킨다.

    return new JsonResult(JsonResult.SUCCESS, "ok");
  }

  @RequestMapping("userinfo")
  public JsonResult userinfo(HttpSession session)throws Exception {
    Member loginMember = (Member)session.getAttribute("loginMember");
    return new JsonResult(JsonResult.SUCCESS, loginMember);
  }
}













//
