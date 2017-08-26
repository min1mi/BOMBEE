package bitcamp.java93.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.java93.dao.ReviewDao;
import bitcamp.java93.domain.Review;
import bitcamp.java93.service.ReviewService;

@Service
public  class ReviewServiceImpl implements ReviewService {
  @Autowired
  ReviewDao reviewDao;

  public void add(Review review) throws Exception {
    reviewDao.insert(review);
  }
  
  public List<Review> get(int no) throws Exception {
    return reviewDao.detail(no);
  }
  
  public List<Review> get2(int  no) throws Exception {
    return reviewDao.detail2(no);
  }

  public void update(Review review) throws Exception {
    reviewDao.update(review.getTrano());

  }

  @Override
  public void delete(int no) throws Exception {
    reviewDao.delete(no);
  }

  @Override
  public void reviewUpdate(int no) throws Exception {
    reviewDao.reviewUpdate(no);
  }

  @Override
  public List<Review> canReviewList(int no, int day) throws Exception {
    System.out.println("서비스임플"+no );
    System.out.println("서비스임플"+day );
    HashMap<String, Integer> dataMap = new HashMap<String, Integer>();
    dataMap.put("mno", no);
    dataMap.put("tno", day);
    return reviewDao.canReviewList(dataMap);
  }

}
