package bitcamp.java93.control.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java93.domain.Trainer;
import bitcamp.java93.service.TrainerService;

@RestController
@RequestMapping("/trainer/")
public class TrainerControl {
  @Autowired
  TrainerService trainerService;
  
  @RequestMapping("add")
  public JsonResult add(Trainer trainer) throws Exception {
    trainerService.add(trainer);
    return new JsonResult(JsonResult.SUCCESS, "ok");
  }
  @RequestMapping("get")
  public JsonResult get(int no, Model model) throws Exception {
    Trainer trainer = trainerService.get(no);
    if (trainer == null) {
      return new JsonResult(JsonResult.FAIL, no+"번 트레이너가 없습니다");
    }
    model.addAttribute("trainer", trainer);
    return new JsonResult(JsonResult.SUCCESS, trainer);
    
  }

  
  @RequestMapping("detail")
  public JsonResult detail(int no) throws Exception {
    System.out.println(no);
    Trainer trainer = trainerService.get(no);
    if (trainer == null) {
      return new JsonResult(JsonResult.FAIL, no + "번 강사가 없습니다.");
    }
    System.out.println(trainer);
    return new JsonResult(JsonResult.SUCCESS, trainer);
  } // service()
  
  
  @RequestMapping("update")
  public JsonResult update(Trainer trainer) throws Exception {
    trainerService.update(trainer);
    return new JsonResult(JsonResult.SUCCESS, "ok");
  }
}
