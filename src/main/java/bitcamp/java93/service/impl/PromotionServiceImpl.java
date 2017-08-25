package bitcamp.java93.service.impl;

import java.util.ArrayList;
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
  public void add(Promotion promotion, int titleNo) throws Exception {
    promotionDao.insert(promotion);
    for (int i = 0; i < promotion.getPhotoList().size(); i++) {
      HashMap<String, Object> valueMap = new HashMap<>();
      valueMap.put("no", promotion.getNo());
      valueMap.put("pimg", promotion.getPhotoList().get(i));
      if(i == titleNo)
        valueMap.put("title", 1);
      else
        valueMap.put("title", 0);
      promotionDao.insertImg(valueMap);
    }
  }
  
  @Override
	public void updatePromotion(Promotion promotion, int titleNo) {
		System.out.println("implement updatePromotion");
		promotionDao.updatePromotion(promotion);
		
		if(promotion.getPhotoList() !=null) {
	    for (int i = 0; i < promotion.getPhotoList().size(); i++) {
	      HashMap<String, Object> valueMap = new HashMap<>();
	      valueMap.put("no", promotion.getPno());
	      valueMap.put("pimg", promotion.getPhotoList().get(i));
	      if(i == titleNo)
	        valueMap.put("title", 1);
	      else
	        valueMap.put("title", 0);
	      promotionDao.insertImg(valueMap);
	    }
		}
	}
  
  public void titleImageInit(int pno) {
  	promotionDao.titleImageInit(pno);
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

  @Override
  public List<Promotion> nextList(int lastNo) throws Exception {
    
    return  promotionDao.nextList(lastNo);
  }
  
  @Override
  public List<Promotion> firstList() throws Exception {
    
    return  promotionDao.firstList();
  }
  
  @Override
  public List<Promotion> healthFirstList(int typeNo) throws Exception {
    
    return  promotionDao.healthFirstList(typeNo);
  }
  
  @Override
  public List<Promotion> healthNextList(int lastNo, int typeNo) throws Exception {
    return  promotionDao.healthNextList(lastNo, typeNo);
  }
  
  @Override
  public List<Promotion> getPromotionList(int no) throws Exception {
    
    return promotionDao.selectPromotionList(no);
  }

  @Override
  public int deletePromotions(ArrayList<Integer> arr) throws Exception {
    for (int i = 0; i < arr.size(); i++) 
        promotionDao.deletePromotions(arr.get(i));
    return 1;
  }

  @Override
  public List<Promotion> getPromotionListTitle(int no) throws Exception {
   
    return promotionDao.selectPromotionListTitle(no);
  }
  
  @Override
	public void delAddImage(String delI) {
		System.out.println("imple 에서:" + delI);
		promotionDao.delAddImage(delI);
	}

  @Override
  public int deltePromotionImg(ArrayList<Integer> arr) {
    for (int i = 0; i < arr.size(); i++) 
      promotionDao.deletePromotionImg(arr.get(i));
    return 1;
  }

  @Override
  public int deletePromotionOne(int pno) throws Exception {
    promotionDao.deletePromotionImg(pno);
    return promotionDao.deletePromotions(pno);
  }

  @Override
  public void updateTitlePic(String titleName) {
    promotionDao.updateTitlePic(titleName);
    
  }

  @Override
  public void scheduleStatus() throws Exception {
    promotionDao.scheduleStatus();
  }
  @Override
  public void expireStatus() throws Exception {
    promotionDao.expireStatus();
  }
  
}







