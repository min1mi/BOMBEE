package bitcamp.java93.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.java93.dao.ChatDao;
import bitcamp.java93.domain.Chat;
import bitcamp.java93.domain.Friend;
import bitcamp.java93.service.ChatService;

@Service
public class ChatServiceImpl implements ChatService {
  @Autowired
  ChatDao chatDao;

  @Override
  public List<Chat> memberlist(int no) throws Exception {
    
     List<Chat> arr = chatDao.selectMemberAll(no);
     for (int i = 0; i < arr.size(); i++) {
       if(arr.get(i).getPm().equals("PM"))
         arr.get(i).setPm("오후");
       else if(arr.get(i).getPm().equals("AM"))
         arr.get(i).setPm("오전");
     }
     return arr;
  }
  @Override
  public List<Chat> trainerlist(int no) throws Exception {
    List<Chat> arr = chatDao.selectTrainerAll(no);
    for (int i = 0; i < arr.size(); i++) {
      if(arr.get(i).getPm().equals("PM"))
        arr.get(i).setPm("오후");
      else if(arr.get(i).getPm().equals("AM"))
        arr.get(i).setPm("오전");
    }
    return arr;
  }
  @Override
  public int memberChatStatus(int no) throws Exception {
    return chatDao.memberChatStatus(no);
  }
  @Override
  public int trainerChatStatus(int no) throws Exception {
    return chatDao.trainerChatStatus(no);
  }
  @Override
  public int updateRead(Chat chat) throws Exception {
    if(chat.getMembertype() == 2) {
      chat.setTrainerno(chat.getMymno());
      chat.setMemberno(chat.getYourmno());
    }else if (chat.getMembertype() == 1) {
      chat.setTrainerno(chat.getYourmno());
      chat.setMemberno(chat.getMymno());
    }
    return chatDao.updateRead(chat);
  }
  
}







