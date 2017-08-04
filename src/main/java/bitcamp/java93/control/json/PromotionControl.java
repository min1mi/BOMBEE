package bitcamp.java93.control.json;

import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java93.domain.Location;
import bitcamp.java93.domain.Promotion;
import bitcamp.java93.service.PromotionService;

@RestController
@RequestMapping("/promotion/")
public class PromotionControl {
  @Autowired ServletContext servletContext;
  @Autowired PromotionService promotionService;
  
  @RequestMapping("list")
  public JsonResult list(Location local) throws Exception {
    System.out.println(local);
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("list", promotionService.list(local));

    return new JsonResult(JsonResult.SUCCESS ,dataMap);
  }
  
  @RequestMapping("tList")
  public JsonResult tList(Location local) throws Exception {
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("list", promotionService.trainerList(local));
    System.out.println(dataMap);
    return new JsonResult(JsonResult.SUCCESS ,dataMap);
  }
  
  @RequestMapping("gps")
  public JsonResult gps(Location local) throws Exception {
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("list", promotionService.LatLonList(local));
   if(local.getTeacherOrPromotion() == 0) {
     
   }
   return new JsonResult(JsonResult.SUCCESS ,dataMap);
  }
  
  @RequestMapping("add")
  public JsonResult add(Promotion promotion) throws Exception {
  	System.out.println("Control");
  	System.out.println(promotion);
  	promotionService.add(promotion);
  	return new JsonResult(JsonResult.SUCCESS, "ok");
  }
  
  @RequestMapping("hot-nextList")
  public JsonResult nextList(int lastNo) throws Exception {
    System.out.println(lastNo);
    if(lastNo <= 1)
    	return new JsonResult(JsonResult.SUCCESS, null);
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("list", promotionService.nextList(lastNo));
    return new JsonResult(JsonResult.SUCCESS ,dataMap);
  }


@RequestMapping("hot-firstList")
  public JsonResult firstList() throws Exception {
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("list", promotionService.firstList());

    return new JsonResult(JsonResult.SUCCESS ,dataMap);
  }
  
  @RequestMapping("health-nextList")
  public JsonResult healthNextList(int lastNo) throws Exception {
    System.out.println(lastNo);
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("list", promotionService.healthNextList(lastNo));

    return new JsonResult(JsonResult.SUCCESS ,dataMap);
  }
  @RequestMapping("health-firstList")
  public JsonResult healthFirstList() throws Exception {
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("list", promotionService.healthFirstList());

    return new JsonResult(JsonResult.SUCCESS ,dataMap);
  }
  
  @RequestMapping("yoga-firstList")
  public JsonResult yogaFirstList() throws Exception {
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("list", promotionService.yogaFirstList());

    return new JsonResult(JsonResult.SUCCESS ,dataMap);
  }
  
  @RequestMapping("pilates-firstList")
  public JsonResult pilatesFirstList() throws Exception {
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("list", promotionService.pilatesFirstList());

    return new JsonResult(JsonResult.SUCCESS ,dataMap);
  }
  
  @RequestMapping("spinning-firstList")
  public JsonResult spinningFirstList() throws Exception {
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("list", promotionService.spinningFirstList());

    return new JsonResult(JsonResult.SUCCESS ,dataMap);
  }
  
  @RequestMapping("yoga-nextList")
  public JsonResult yogaNextList(int lastNo) throws Exception {
    System.out.println(lastNo);
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("list", promotionService.yogaNextList(lastNo));

    return new JsonResult(JsonResult.SUCCESS ,dataMap);
  }
  
  @RequestMapping("pilates-nextList")
  public JsonResult pilatesNextList(int lastNo) throws Exception {
    System.out.println(lastNo);
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("list", promotionService.pilatesNextList(lastNo));

    return new JsonResult(JsonResult.SUCCESS ,dataMap);
  }
  
  @RequestMapping("spinning-nextList")
  public JsonResult spinningNextList(int lastNo) throws Exception {
    System.out.println(lastNo);
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("list", promotionService.spinningNextList(lastNo));

    return new JsonResult(JsonResult.SUCCESS ,dataMap);
  }
  
//  @RequestMapping("add")
//  public void add(Promotion promotion) throws Exception {
//  	System.out.println("Control");
//  	System.out.println(promotion);
//  	
//  }
  
//  @RequestMapping("detail")
//  public JsonResult detail(int no) throws Exception {
//    Promotion promotion = teacherService.get(no);
//    if (teacher == null) {
//      return new JsonResult(JsonResult.FAIL, no + "번 강사가 없습니다.");
//    }
//    return new JsonResult(JsonResult.SUCCESS, teacher);
//  }
//  
//  @RequestMapping("update")
//  public JsonResult update(Teacher teacher) throws Exception {
//    teacherService.update(teacher);
//    return new JsonResult(JsonResult.SUCCESS, "ok");
//  }
//  
//  @RequestMapping("delete")
//  public JsonResult delete(int no) throws Exception {
//    teacherService.remove(no);
//    return new JsonResult(JsonResult.SUCCESS, "ok");
//  }  
//  
//  @RequestMapping("add")
//  public JsonResult add(Teacher teacher, String filenames) throws Exception {
//    String[] nameList = filenames.split(",");
//    ArrayList<String> photoList = new ArrayList<>();
//    for (String name : nameList) {
//      photoList.add(name);
//    }
//    teacher.setPhotoList(photoList);
//    
//    teacherService.add(teacher);
//    return new JsonResult(JsonResult.SUCCESS, "ok");
//  }
//  
//  @RequestMapping("upload")
//  public JsonResult upload(MultipartFile[] files) throws Exception {
//    ArrayList<String> fileList = new ArrayList<>();
//    for (MultipartFile file : files) {
//      if (file.isEmpty())
//        continue;
//      String filename = getNewFilename();
//      file.transferTo(new File(servletContext.getRealPath("/teacher/photo/" + filename)));
//      fileList.add(filename);
//    }
//    return new JsonResult(JsonResult.SUCCESS, fileList);
//  }
//  
//  int count = 0;
//  synchronized private String getNewFilename() {
//    if (count > 100) {
//      count = 0;
//    }
//    return String.format("%d_%d", System.currentTimeMillis(), ++count); 
//  }
}









