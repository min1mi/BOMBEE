package bitcamp.java93.dao;

import java.util.List;

import bitcamp.java93.domain.Review;
public interface ReviewDao {

  int insert(Review review);
  List<Review> detail(int no);
 
}
