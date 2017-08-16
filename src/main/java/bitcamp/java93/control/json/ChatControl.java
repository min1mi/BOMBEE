package bitcamp.java93.control.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java93.service.ChatService;

@RestController
@RequestMapping("/chat/")
public class ChatControl {
  @Autowired
  ChatService chatService;

  @RequestMapping("memberList")
  public JsonResult selectMemberAll(int no) throws Exception {
    return new JsonResult(JsonResult.SUCCESS, chatService.memberlist(no));
  }
  @RequestMapping("trainerList")
  public JsonResult selectTrainerAll(int no) throws Exception {
    System.out.println(chatService.trainerlist(no));
    return new JsonResult(JsonResult.SUCCESS, chatService.trainerlist(no));
  }

//  @RequestMapping("searchMusician")
//  public JsonResult searchMusician(HttpSession session, String location) throws Exception {
//    HashMap<String,Object> dataMap = new HashMap<>();
//    List<Musician> search= (List<Musician>)musicianService.searchMusician(getLoginMember(session).getNo() ,location);
//    dataMap.put("listSurf", search);
//    return new JsonResult(JsonResult.SUCCESS, dataMap);
//  }

}
