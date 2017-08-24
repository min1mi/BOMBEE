package bitcamp.java93.control.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java93.domain.Friend;
import bitcamp.java93.domain.Member;
import bitcamp.java93.domain.Review;
import bitcamp.java93.domain.Trainer;
import bitcamp.java93.service.ReviewService;

@RestController
@RequestMapping("/review/")
public class ReviewControl {
  @Autowired
  ReviewService reviewService;


  @RequestMapping("add")
  public JsonResult add(Review review) throws Exception {
    reviewService.add(review);
    return new JsonResult(JsonResult.SUCCESS, review);
  }


  @RequestMapping("detail")
  public JsonResult detail(int no) throws Exception {
    
    
      return new JsonResult(JsonResult.FAIL, reviewService.get(no));
  }

  @RequestMapping("detail2")
  public JsonResult detail2(int no) throws Exception {
    ;
      return new JsonResult(JsonResult.SUCCESS, reviewService.get2(no));
  } // service()friend
  
  @RequestMapping("detail3")
  public JsonResult detail3(int no) throws Exception {
    return new JsonResult(JsonResult.FAIL, reviewService.get3(no));
  } // service()friend
  
  @RequestMapping("boolean")
  public JsonResult update(Review review) throws Exception {
    reviewService.update(review);
    return new JsonResult(JsonResult.SUCCESS, "ok");
  }


}
