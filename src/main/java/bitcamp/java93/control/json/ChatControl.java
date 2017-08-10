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

  @RequestMapping("chatList")
  public JsonResult selectAll(int no) throws Exception {
    chatService.list(no);
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
