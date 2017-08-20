package bitcamp.java93.control.json;

import java.io.File;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bitcamp.java93.domain.Usermeal;
import bitcamp.java93.service.UsermealService;
import net.coobird.thumbnailator.Thumbnails;

@RestController
@RequestMapping("/management/")
public class UsermealControl {
  @Autowired
  UsermealService usermealService;
  @Autowired
  ServletContext ctx;

  @RequestMapping("usermeal-list")
  public JsonResult list(String startDate, String endDate, int trainingNo) throws Exception {

    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("mealList", usermealService.list(startDate, endDate, trainingNo));
    return new JsonResult(JsonResult.SUCCESS, dataMap);
  }


  @RequestMapping("usermeal-add")
  public JsonResult add(Usermeal usermeal, MultipartFile[] files) throws Exception {

    System.out.println(usermeal);
    String newFilename = this.getNewFilename();
    File file = new File(ctx.getRealPath("/upload/" + newFilename));
    files[0].transferTo(file);

    usermeal.setMealpicture("/upload/" + newFilename);

    File thumbnailfile = new File(ctx.getRealPath("/upload/" + newFilename + "_140"));
    Thumbnails.of(file).size(140, 140).outputFormat("png").toFile(thumbnailfile);

    thumbnailfile = new File(ctx.getRealPath("/upload/" + newFilename + "_350"));
    Thumbnails.of(file).size(350, 350).outputFormat("png").toFile(thumbnailfile);

    System.out.println(usermeal);
    usermealService.add(usermeal);

    return new JsonResult(JsonResult.SUCCESS, "ok");
  }

  @RequestMapping("usermeal-update")
  public JsonResult upload(Usermeal usermeal, MultipartFile[] files) throws Exception {

    String newFilename = this.getNewFilename();
    File file = new File(ctx.getRealPath("/upload/" + newFilename));
    files[0].transferTo(file);

    usermeal.setMealpicture("/upload/" + newFilename);

    File thumbnailfile = new File(ctx.getRealPath("/upload/" + newFilename + "_140"));
    Thumbnails.of(file).size(140, 140).outputFormat("png").toFile(thumbnailfile);

    thumbnailfile = new File(ctx.getRealPath("/upload/" + newFilename + "_350"));
    Thumbnails.of(file).size(350, 350).outputFormat("png").toFile(thumbnailfile);

    System.out.println(usermeal);
    usermealService.update(usermeal);

    return new JsonResult(JsonResult.SUCCESS, "ok");
  }

  @RequestMapping("nopicmeal-update")
  public JsonResult nopicUpload(Usermeal usermeal) throws Exception {
    System.out.println(usermeal);
    usermealService.update(usermeal);

    return new JsonResult(JsonResult.SUCCESS, "ok");
  }

  @RequestMapping("confirm")
  public JsonResult confirm(int mealno) throws Exception {
    usermealService.confirm(mealno);

    return new JsonResult(JsonResult.SUCCESS, "ok");
  }

  @RequestMapping("usermeal-delete")
  public JsonResult delete(int mealno) throws Exception {
    usermealService.remove(mealno);
   return new JsonResult(JsonResult.SUCCESS, "ok");
  }

  @RequestMapping("trainingList")
  public JsonResult trainingList(int no) throws Exception {
    return new JsonResult(JsonResult.SUCCESS, usermealService.traingList(no));
  }

  @RequestMapping("usersList")
  public JsonResult usersList(int no) throws Exception {
    return new JsonResult(JsonResult.SUCCESS, usermealService.usersList(no));
  }

  int count = 0;
  synchronized private String getNewFilename() {
    if (count > 100) {
      count = 0;
    }
    return String.format("%d_%d", System.currentTimeMillis(), ++count);
  }


}
