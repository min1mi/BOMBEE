package bitcamp.java93.control.json;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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
    System.out.println(local.getLat());
    System.out.println(local.getLon());
    HashMap<String,Object> dataMap = new HashMap<>();
    
   if(local.getTeacherOrPromotion() == 0) {
     dataMap.put("list", promotionService.list(local));
   }else {
     dataMap.put("list", promotionService.trainerList(local));
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
    System.out.println(promotion);
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
    promotionService.deltePromotionImg(arr);
    return promotionService.deletePromotions(arr);
  }
  
  @RequestMapping("deletePromotionOne")
  public int deletePromotions(int no) throws Exception {
    System.out.println(no);
    return promotionService.deletePromotionOne(no);
  }
  
  @RequestMapping("promotionTitle")
  public JsonResult getPromotionTitle(int no) throws Exception {
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("list", promotionService.getPromotionListTitle(no));

    return new JsonResult(JsonResult.SUCCESS, dataMap);
  }
  
  @RequestMapping("promotionTitlePicList")
  public JsonResult getPromotionTitlePicList(int no) throws Exception {
    return new JsonResult(JsonResult.SUCCESS, promotionService.getPromotionTitlePicList(no));
  }
  
  @RequestMapping("add")
  public JsonResult addPromotion(Promotion promotion, MultipartFile[] files) throws Exception {
    System.out.println(promotion);
    String titleName = promotion.getTitlePic();
    int titleNo = -1;
    
    
    ArrayList<String> fileList = new ArrayList<>();
    
    for (int i = 0; i < files.length; i++) {
        if (files[i].isEmpty()) 
          continue;
        
        String newFilename = this.getNewFilename();
        File file = new File(ctx.getRealPath("/upload/" + newFilename));
        System.out.println(ctx.getRealPath("/upload/" + newFilename));
        files[i].transferTo(file);
        File thumbnail = new File(ctx.getRealPath("/upload/" + newFilename + "_titleMainList"));
        Thumbnails.of(file).size(190, 150).outputFormat("png").toFile(thumbnail);
        thumbnail = new File(ctx.getRealPath("/upload/" + newFilename + "_promotion"));
        Thumbnails.of(file).size(414, 350).outputFormat("png").toFile(thumbnail);
        
        ////////
        thumbnail = new File(ctx.getRealPath("/upload/" + newFilename + "_210"));
        Thumbnails.of(file).size(210, 170).outputFormat("png").toFile(thumbnail);
        // 아이폰6+
        //////////
        
        ///
        thumbnail = new File(ctx.getRealPath("/upload/" + newFilename + "_190"));
        Thumbnails.of(file).size(190, 170).outputFormat("png").toFile(thumbnail);
        /// 아이폰6
        
        //
        thumbnail = new File(ctx.getRealPath("/upload/" + newFilename + "_170"));
        Thumbnails.of(file).size(170, 170).outputFormat("png").toFile(thumbnail);
        
        // 아이폰5
        
        fileList.add(newFilename);
      }
    if (titleName != null) {
      for (int i = 0; i < files.length; i++) {
        if (files[i].getOriginalFilename().equals(titleName))
          titleNo = i;
      }
    }
    promotion.setPhotoList(fileList);
    promotionService.add(promotion, titleNo);
    return new JsonResult(JsonResult.SUCCESS, "ok");
  }
  
  @RequestMapping("update")
  public JsonResult addPromotion(Promotion promotion, MultipartFile[] files, String[] delImage, int indexPic) throws Exception {
  	System.out.println("update control!!");
  	System.out.println("promotion" + promotion);
  	System.out.println("delImage:" + delImage);
  	
  	// 1 =  업로드 안했지만 전타이틀 사진과 같을 때  
    // 2 = 업로드 안했지만 타이틀이 바뀜 
  	// 3 = 새로 업로드된 사진이 타이틀 사진일때
    // 4 = 새로 업로드 됬지만 전타이틀 사진과 같을때 
    // 5 = 새로 업로드 됬지만 전타이틀 사진과 다르고, 전에 올린사진 중에 하나가 타이틀 일때.
  	System.out.println("indexPic:"+ indexPic); 
 // 대표 이미지 초기화
    // 2 3 5 일떄 초기화
  	if (indexPic == 2 || indexPic == 3 || indexPic ==5) 
  	  promotionService.titleImageInit(promotion.getPno());
  	String titleName = promotion.getTitlePic();
    int titleNo = -1;

    System.out.println(titleName);
    ArrayList<String> fileList = new ArrayList<>();
    
        
    
  
  	if(delImage != null) {
  		System.out.println("컨트롤~이미지 삭제!!!");
  		for (String delI : delImage){
    		promotionService.delAddImage(delI);
    	}
  	}
  	
  	if (files != null) {
  	 for (int i = 0; i < files.length; i++) {
       if (files[i].isEmpty()) 
         continue;

       String newFilename = this.getNewFilename();
       File file = new File(ctx.getRealPath("/upload/" + newFilename));
       System.out.println(ctx.getRealPath("/upload/" + newFilename));
       files[i].transferTo(file);
       
       File thumbnail = new File(ctx.getRealPath("/upload/" + newFilename + "_titleMainList"));
       Thumbnails.of(file).size(190, 150).outputFormat("png").toFile(thumbnail);
       thumbnail = new File(ctx.getRealPath("/upload/" + newFilename + "_promotion"));
       Thumbnails.of(file).size(414, 350).outputFormat("png").toFile(thumbnail);
       
       ////////
       thumbnail = new File(ctx.getRealPath("/upload/" + newFilename + "_210"));
       Thumbnails.of(file).size(210, 170).outputFormat("png").toFile(thumbnail);
       // 아이폰6+
       //////////
       
       ///
       thumbnail = new File(ctx.getRealPath("/upload/" + newFilename + "_190"));
       Thumbnails.of(file).size(190, 170).outputFormat("png").toFile(thumbnail);
       /// 아이폰6
       
       //
       thumbnail = new File(ctx.getRealPath("/upload/" + newFilename + "_170"));
       Thumbnails.of(file).size(170, 170).outputFormat("png").toFile(thumbnail);
       
       // 아이폰5
         
       fileList.add(newFilename);
     }
  	 
  	 if (titleName != null) {
       for (int i = 0; i < files.length; i++) {
         if (files[i].getOriginalFilename().equals(titleName))
           titleNo = i;
       }
     }
  	
  	 System.out.println("fileList:" + fileList);
     promotion.setPhotoList(fileList);
     System.out.println("promotion.getPhotoList()" + promotion.getPhotoList());
  	}
  	
  	if (indexPic == 2 || indexPic == 3 || indexPic ==5) 
  	  promotionService.updateTitlePic(titleName);
     promotionService.updatePromotion(promotion, titleNo);
     return new JsonResult(JsonResult.SUCCESS, "ok");
  }
  
  @Scheduled(cron="0 0 0 * * ?")
  public void promotionSchedule() throws Exception {
    promotionService.scheduleStatus();
    promotionService.expireStatus();
    System.out.println("바꼇음");
  }
  int count = 0;
  synchronized private String getNewFilename() {
    if (count > 100) {
      count = 0;
    }
    return String.format("%d_%d", System.currentTimeMillis(), ++count); 
  }
}
  









