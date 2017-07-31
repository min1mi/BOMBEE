package bitcamp.java93.control.json;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java93.domain.Usermeal;
import bitcamp.java93.service.UsermealService;

@RestController
@RequestMapping("/management/")
public class UsermealControl {
  @Autowired
  UsermealService usermealService;
  
  @RequestMapping("usermeal-list")
  public JsonResult list(String startDate, String endDate) throws Exception {
    
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("mealList", usermealService.list(startDate, endDate));
    return new JsonResult(JsonResult.SUCCESS, dataMap);
  }
  
  @RequestMapping("usermeal-add")
  public JsonResult add(Usermeal usermeal) throws Exception {
    System.out.println("imcoming");
    usermealService.add(usermeal);
    System.out.println("datacoming");
    return new JsonResult(JsonResult.SUCCESS, "ok");
  }
  
}
