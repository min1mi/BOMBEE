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
  @RequestMapping("memberChat")
  public int memberChatStatus(int no) throws Exception {
    return chatService.memberChatStatus(no);
  }
  @RequestMapping("trainerChat")
  public int trainerChatStatus(int no) throws Exception {
    return chatService.trainerChatStatus(no);
  }
}
