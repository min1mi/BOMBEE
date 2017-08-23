package bitcamp.java93.service;

import java.util.List;

import bitcamp.java93.domain.Friend;
import bitcamp.java93.domain.Member;
import bitcamp.java93.domain.Review;
import bitcamp.java93.domain.Trainer;

public interface ReviewService {
  /*read-only : list, get*/


  
  List<Review> get(int no) throws Exception;
  void add(Review review) throws Exception;
  Review get2(Review review) throws Exception;
  Review get3(Review review) throws Exception;
  void update(Review review) throws Exception;
  
}