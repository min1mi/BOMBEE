package bitcamp.java93.control.json;
 
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java93.domain.Schedule;
import bitcamp.java93.domain.Trainer;
import bitcamp.java93.service.ScheduleService;
import bitcamp.java93.service.TrainerService;

@RestController
@RequestMapping("/schedule/")
public class ScheduleControl {
  @Autowired
  ScheduleService scheduleService;
  @Autowired
  TrainerService trainerService;
  
  
  @RequestMapping("get")
  public JsonResult get(int no, Model model) throws Exception {
    Trainer trainer = trainerService.get(no);
    if (trainer == null) {
      return new JsonResult(JsonResult.FAIL, no+"번 트레이너가 없습니다");
    }
    model.addAttribute("trainer", trainer);
    return new JsonResult(JsonResult.SUCCESS, trainer);
     
  }
  @RequestMapping("insert")
  public JsonResult insert(Schedule schedule) throws Exception {
    scheduleService.insert(schedule);
    System.out.println(schedule);
    return new JsonResult(JsonResult.SUCCESS, "ok");
  }
  
  @RequestMapping("detail")
  public JsonResult detail(int no) throws Exception {
    
    Schedule schedule = scheduleService.get(no);
    if (schedule == null) {
      return new JsonResult(JsonResult.FAIL, no + "번 강사가 없습니다.");
    }
    return new JsonResult(JsonResult.SUCCESS, schedule);
  } // service()
  
  @RequestMapping("delete")
  public JsonResult delete(int no) throws Exception {
    scheduleService.remove(no);
   return new JsonResult(JsonResult.SUCCESS, "ok");
  }
    
  private Trainer getLoginTrainer(HttpSession session) {
    Trainer loginMember = (Trainer) session.getAttribute("loginMember");
    return loginMember;
  }
  
}

