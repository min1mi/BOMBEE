package bitcamp.java93.control.json;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java93.service.MemberService;

@RestController
@RequestMapping("/member/")
public class MemberControl {
  @Autowired
  MemberService memberService;
  
  @RequestMapping("list")
  public JsonResult list() throws Exception {
    
    HashMap<String,Object> dataMap = new HashMap<>();
    return new JsonResult(JsonResult.SUCCESS, dataMap);
  }
}
