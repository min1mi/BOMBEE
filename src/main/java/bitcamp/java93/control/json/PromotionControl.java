package bitcamp.java93.control.json;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bitcamp.java93.domain.Location;
import bitcamp.java93.domain.Promotion;
import bitcamp.java93.service.PromotionService;
import net.coobird.thumbnailator.Thumbnails;

@RestController
@RequestMapping("/promotion/")
public class PromotionControl {
  @Autowired ServletContext servletContext;
  @Autowired PromotionService promotionService;
  @Autowired ServletContext ctx;
  
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
  

  
  @RequestMapping("hot-nextList")
  public JsonResult nextList(int lastNo, int typeNo) throws Exception {
    System.out.println(typeNo);
    HashMap<String,Object> dataMap = new HashMap<>();
    if(lastNo <= 1)
    	return new JsonResult(JsonResult.SUCCESS, dataMap);
    dataMap.put("list", promotionService.nextList(lastNo));
    return new JsonResult(JsonResult.SUCCESS ,dataMap);
  }


@RequestMapping("hot-firstList")
  public JsonResult firstList(int lastNo, int typeNo) throws Exception {
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("list", promotionService.firstList());

    return new JsonResult(JsonResult.SUCCESS ,dataMap);
  }
  
  @RequestMapping("health-nextList")
  public JsonResult healthNextList(int lastNo, int typeNo) throws Exception {
    System.out.println(typeNo);
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("list", promotionService.healthNextList(lastNo, typeNo));

    return new JsonResult(JsonResult.SUCCESS ,dataMap);
  }
  @RequestMapping("health-firstList")
  public JsonResult healthFirstList(int typeNo) throws Exception {
    System.out.println(typeNo);
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("list", promotionService.healthFirstList(typeNo));

    return new JsonResult(JsonResult.SUCCESS ,dataMap);
  }
  
  @RequestMapping("detail")
  public JsonResult detail(int no) throws Exception {
    System.out.println(no);
    Promotion promotion = promotionService.get(no);
    if (promotion == null)
        return new JsonResult(JsonResult.FAIL, no+"번 강사가 없습니다.");
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("promotion", promotion);

    return new JsonResult(JsonResult.SUCCESS ,dataMap);
  }
  
  @RequestMapping("promotion")
  public JsonResult getPromotion(int no) throws Exception {
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("list", promotionService.getPromotionList(no));

    return new JsonResult(JsonResult.SUCCESS, dataMap);
  } // service()
  
  @RequestMapping("deletePromotions")
  public int deletePromotions(HttpServletRequest request) throws Exception {
    String[] arr1 = request.getParameterValues("list[]");
    ArrayList<Integer> arr = new ArrayList<Integer>();
    for (int i=0; i < arr1.length; i++) 
      arr.add(Integer.parseInt(arr1[i]));
    return promotionService.deletePromotions(arr);
  }
  @RequestMapping("promotionTitle")
  public JsonResult getPromotionTitle(int no) throws Exception {
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("list", promotionService.getPromotionListTitle(no));

    return new JsonResult(JsonResult.SUCCESS, dataMap);
  }
  
  @RequestMapping("add")
  public JsonResult addPromotion(Promotion promotion, MultipartFile[] files) throws Exception {
    System.out.println(promotion);
    
    ArrayList<String> fileList = new ArrayList<>();
    
    for (int i = 0; i < files.length; i++) {
        if (files[i].isEmpty()) 
          continue;
        
        String newFilename = this.getNewFilename();
        File file = new File(ctx.getRealPath("/upload/" + newFilename));
        System.out.println(ctx.getRealPath("/upload/" + newFilename));
        files[i].transferTo(file);
        
        File thumbnail = new File(ctx.getRealPath("/upload/" + newFilename + "_200"));
        Thumbnails.of(file).size(200, 200).outputFormat("png").toFile(thumbnail);
          
        fileList.add(newFilename);
      }
    System.out.println(fileList);
    promotion.setPhotoList(fileList);
    promotionService.add(promotion);
    System.out.println(promotion);
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









