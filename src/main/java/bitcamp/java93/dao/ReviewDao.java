package bitcamp.java93.dao;

import java.util.List;

import bitcamp.java93.domain.Review;
import bitcamp.java93.domain.Trainer;
public interface ReviewDao {

  int insert(Review review);
  List<Review> detail(int no);
  Review detail2(Review review);
  int update(int no);
  
}
