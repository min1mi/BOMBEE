package bitcamp.java93.control.json;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bitcamp.java93.domain.Trainer;
import bitcamp.java93.service.TrainerService;
import net.coobird.thumbnailator.Thumbnails;

@RestController
@RequestMapping("/trainer/")
public class TrainerControl {
  @Autowired
  TrainerService trainerService;
  @Autowired
  ServletContext ctx;
  
  @RequestMapping("add")
  public JsonResult add(Trainer trainer) throws Exception {
    trainerService.add(trainer);
    return new JsonResult(JsonResult.SUCCESS, trainer);
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
    
    Trainer trainer = trainerService.get(no);
    if (trainer == null) {
      return new JsonResult(JsonResult.FAIL, no + "번 강사가 없습니다.");
    }
    return new JsonResult(JsonResult.SUCCESS, trainer);
  } // service()
  
  @RequestMapping("detail2")
  public JsonResult detail2(int no) throws Exception {
    
    Trainer trainer = trainerService.get(no);
    if (trainer == null) {
      return new JsonResult(JsonResult.FAIL, no + "번 강사가 없습니다.");
    }
    return new JsonResult(JsonResult.SUCCESS, trainer);
  } // service()
  
  
  @RequestMapping("update")
  public JsonResult update(Trainer trainer, MultipartFile[] files) throws Exception {
    String newFilename = this.getNewFilename();
    File file = new File(ctx.getRealPath("/upload/" + newFilename));
    files[0].transferTo(file);
    
    trainer.setTcherpic("/upload/" + newFilename);
    
    File thumbnailfile = new File(ctx.getRealPath("/upload/" + newFilename + "_140"));
    Thumbnails.of(file).size(140, 140).outputFormat("png").toFile(thumbnailfile);
    
    thumbnailfile = new File(ctx.getRealPath("/upload/" + newFilename + "_350"));
    Thumbnails.of(file).size(350, 350).outputFormat("png").toFile(thumbnailfile);
    
    trainerService.update(trainer);
    
    
    
    return new JsonResult(JsonResult.SUCCESS, "ok");
  }
  @RequestMapping("update2")
  public JsonResult update(Trainer trainer) throws Exception {
    trainerService.update(trainer);
    return new JsonResult(JsonResult.SUCCESS, "ok");
  }
  
  
  int count = 0;
  synchronized private String getNewFilename() {
    if (count > 100) {
      count = 0;
    }
    return String.format("%d_%d", System.currentTimeMillis(), ++count); 
  }

}

