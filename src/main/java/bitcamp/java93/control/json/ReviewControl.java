package bitcamp.java93.control.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import bitcamp.java93.domain.Review;  
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
      return new JsonResult(JsonResult.SUCCESS, reviewService.get2(no));
  } // service()friend
  
  @RequestMapping("boolean")
  public JsonResult update(Review review) throws Exception {
    reviewService.update(review);
    return new JsonResult(JsonResult.SUCCESS, "ok");
  }
  
  @RequestMapping("delete")
  public JsonResult delete(int no) throws Exception {
    reviewService.delete(no);
      return new JsonResult(JsonResult.SUCCESS, "OK");
  } // service()friend
  
  @RequestMapping("reviewUpdate")
  public JsonResult reviewUpdate(int no) throws Exception {
    reviewService.reviewUpdate(no);
      return new JsonResult(JsonResult.SUCCESS, "OK");
  } 
  
  @RequestMapping("canReviewList")
  public JsonResult canReviewList(int no, int day) throws Exception {
    reviewService.canReviewList(no, day);// no가 mno day가 tno
      return new JsonResult(JsonResult.SUCCESS, "OK");
  } 


}
