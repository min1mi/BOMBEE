package bitcamp.java93.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.java93.dao.PromotionDao;
import bitcamp.java93.domain.Location;
import bitcamp.java93.domain.Promotion;
import bitcamp.java93.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService {
  
  @Autowired
  PromotionDao promotionDao;
  
  public List<Promotion> list(Location local) throws Exception {
    HashMap<String,Object> valueMap = new HashMap<>();
    valueMap.put("lat", local.getLat());
    valueMap.put("lon", local.getLon());
    return promotionDao.selectList(valueMap);
  }
  
  public Promotion get(int no) throws Exception {
    return promotionDao.selectOne(no);
  }
  public List<Promotion> trainerList(Location local) throws Exception {
    HashMap<String,Object> valueMap = new HashMap<>();
    valueMap.put("lat", local.getLat());
    valueMap.put("lon", local.getLon());
    return promotionDao.trainerList(valueMap);
  }
  
  // XML 태그로 트랜잭션을 설정하게 되면 @Transactional 애노테이션은 필요없다.
  //@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
  public void add(Promotion promotion) throws Exception {
    promotionDao.insert(promotion);
    promotionDao.insertImg(promotion);
  }
  
  //XML 태그로 트랜잭션을 설정하게 되면 @Transactional 애노테이션은 필요없다.
  //@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
//  public void update(Promotion promotion) throws Exception {
//    int count = promotionDao.update(promotion);
//    if (count < 1) {
//      throw new Exception(promotion.getPno() + "번 프로모션을 찾을 수 없습니다.");
//    }
//  }
  
//  private void insertPhoto(int promotionNo, List<String> photoPathList) {
//    if (photoPathList == null)
//      return;
//    
//    HashMap<String,Object> valueMap = new HashMap<>();
//    valueMap.put("promotionNo", promotionNo);
//    
//    for (String photoPath : photoPathList) {
//      valueMap.put("photoPath", photoPath);
//      promotionDao.insertPhoto(valueMap);
//    }
//  }
  
  //XML 태그로 트랜잭션을 설정하게 되면 @Transactional 애노테이션은 필요없다.
  //@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
  public void remove(int no) throws Exception {
    promotionDao.deletePhoto(no);
    int count = promotionDao.delete(no);
    if (count < 1) {
      throw new Exception(no + "번 프로모션을 찾을 수 없습니다.");
    }
  }


  @Override
  public List<Promotion> LatLonList(Location local) throws Exception {
    HashMap<String,Object> valueMap = new HashMap<>();
    valueMap.put("lat", local.getLat());
    valueMap.put("lon", local.getLon());
    return promotionDao.latLonList(valueMap);
  }


}







