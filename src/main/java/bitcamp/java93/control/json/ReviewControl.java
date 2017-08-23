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
  public JsonResult detail2(Review review) throws Exception {
    Review review1 = reviewService.get2(review);
    if(review1 != null){
      return new JsonResult(JsonResult.SUCCESS, review1);
    }else{
      return new JsonResult(JsonResult.FAIL, review1);
    }
  } // service()friend
  
  @RequestMapping("boolean")
  public JsonResult update(Review review) throws Exception {
    System.out.println("==========================="+review.getTrano());
    reviewService.update(review);
    return new JsonResult(JsonResult.SUCCESS, "ok");
  }


}
