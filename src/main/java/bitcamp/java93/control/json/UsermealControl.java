package bitcamp.java93.control.json;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java93.domain.Member;
import bitcamp.java93.domain.Usermeal;
import bitcamp.java93.service.UsermealService;

@RestController
@RequestMapping("/management/")
public class UsermealControl {
  @Autowired
  UsermealService usermealService;
  
  @RequestMapping("usermeal-list")
  public JsonResult list(String startDate, String endDate) throws Exception {
    
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("mealList", usermealService.list(startDate, endDate));
    return new JsonResult(JsonResult.SUCCESS, dataMap);
  }
  
  @RequestMapping("usermeal-add")
  public JsonResult add(Usermeal usermeal, HttpSession session) throws Exception {
    if (getLoginMember(session).getMembertype() == 1) {
      usermealService.add(usermeal);
      return new JsonResult(JsonResult.SUCCESS, "ok");
    } else {
      return new JsonResult(JsonResult.SUCCESS, "trainer");
    }
    
  }
  
  private Member getLoginMember(HttpSession session) {
    Member loginMember = (Member) session.getAttribute("loginMember");
    return loginMember;
  }
}
