package bitcamp.java93.control.json;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java93.domain.Friend;
import bitcamp.java93.service.FriendService;

@RestController
@RequestMapping("/friend/")
public class FriendControl {
  @Autowired
  FriendService friendService;
  
  
 
  @RequestMapping("add")
  public JsonResult add(Friend friend) throws Exception {
    friendService.add(friend);
    System.out.println(friend);
    return new JsonResult(JsonResult.SUCCESS, "ok");
  }
  
  @RequestMapping("detail")
  public JsonResult detail(int no) throws Exception {
    
    Friend friend = friendService.get(no);
    if (friend == null) {
      return new JsonResult(JsonResult.FAIL, no + "번 강사가 없습니다.");
    }
    return new JsonResult(JsonResult.SUCCESS, friend);
  } // service(
  
}

