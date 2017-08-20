package bitcamp.java93.control.json;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java93.domain.Friend;
import bitcamp.java93.domain.Trainer;
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
  @RequestMapping("add2")
  public JsonResult add2(Friend friend) throws Exception {
    friendService.add2(friend);
    System.out.println(friend);
    return new JsonResult(JsonResult.SUCCESS, "ok");
  }

  
  @RequestMapping("detail")
  public JsonResult detail(Friend friend) throws Exception {
    friendService.detail(friend);

   return new JsonResult(JsonResult.SUCCESS, "ok");
  }
  @RequestMapping("detail2")
  public JsonResult detail2(int mno, int tno) throws Exception {
    
    Friend friend = friendService.get2(mno, tno);
 
    return new JsonResult(JsonResult.SUCCESS, friend);
  } // service()friend
  
  @RequestMapping("delete")
  public JsonResult delete(Friend friend) throws Exception {
    friendService.remove(friend);

   return new JsonResult(JsonResult.SUCCESS, "ok");
  }
  @RequestMapping("delete2")
  public JsonResult delete2(Friend friend) throws Exception {
    friendService.remove2(friend);

   return new JsonResult(JsonResult.SUCCESS, "ok");
  }
  
  @RequestMapping("addList")
  public JsonResult addList(int no) throws Exception {
   return new JsonResult(JsonResult.SUCCESS, friendService.addList(no));
  }
  
  @RequestMapping("friendDelete") // 친구 수락 거절했을때 tcher_trainer 삭제하는 요청
  public JsonResult friendDelete(int no, int mno) throws Exception {
   return new JsonResult(JsonResult.SUCCESS, friendService.friendDelete(no, mno));
  }


}
