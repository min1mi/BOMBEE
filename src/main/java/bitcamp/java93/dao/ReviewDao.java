package bitcamp.java93.dao;

import java.util.List;

import bitcamp.java93.domain.Review;
import bitcamp.java93.domain.Trainer;
public interface ReviewDao {

  int insert(Review review);
  List<Review> detail(int no);
  List<Review> detail2(int no);
  Double detail3(int no);
  int update(int no);
  void delete(int no);
  void reviewUpdate(int no);
  List<Review> canReviewList(int no, int day);
}
