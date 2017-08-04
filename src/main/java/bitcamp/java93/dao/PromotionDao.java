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
  List<Promotion> healthFirstList();
  List<Promotion> yogaFirstList();
  List<Promotion> pilatesFirstList();
  List<Promotion> spinningFirstList();
  List<Promotion> healthNextList(int lastNo);
  List<Promotion> yogaNextList(int lastNo);
  List<Promotion> pilatesNextList(int lastNo);
  List<Promotion> spinningNextList(int lastNo);
  Promotion selectOne(int no);
  Promotion selectOneByEmailPassword(Map<String,Object> valueMap);
  int insert(Promotion Promotion);
  int insertImg(Promotion Promotion);
  int delete(int no);
  int update(Promotion Promotion);
void insertPhoto(HashMap<String, Object> valueMap);
void deletePhoto(int no);
 List<Promotion> latLonList(Map<String,Object> valueMap);
}
