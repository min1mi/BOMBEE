package bitcamp.java93.control.json;

import org.springframework.beans.factory.annotation.Autowired;
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
}
