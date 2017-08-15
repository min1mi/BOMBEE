package bitcamp.java93.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bitcamp.java93.domain.Promotion;

public interface PromotionDao {
  List<Promotion> selectList(Map<String,Object> valueMap);
  List<Promotion> trainerList(Map<String,Object> valueMap);
  List<Promotion> nextList(int lastNo);
  List<Promotion> firstList();
  List<Promotion> healthFirstList(int typeNo);
  List<Promotion> healthNextList(int lastNo, int typeNo);
  Promotion selectOne(int no);
  Promotion selectOneByEmailPassword(Map<String,Object> valueMap);
  int insert(Promotion Promotion);
  int insertImg(HashMap<String, Object> valueMap);
  int delete(int no);
  int update(Promotion Promotion);
  void insertPhoto(HashMap<String, Object> valueMap);
  void deletePhoto(int no);
 List<Promotion> latLonList(Map<String,Object> valueMap);
 List<Promotion> selectPromotionList(int no);
 List<Promotion> selectPromotionListTitle(int no);
 int deletePromotions(int no);
 int updatePromotion(Promotion Promotion);
 void delAddImage(String delI);
 int deletePromotionImg(int pno);
}
