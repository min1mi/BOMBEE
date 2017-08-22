package bitcamp.java93.control.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java93.domain.Member;
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



}
