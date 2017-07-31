package bitcamp.java93.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bitcamp.java93.domain.Promotion;

public interface PromotionDao {
  List<Promotion> selectList(Map<String,Object> valueMap);
  Promotion selectOne(int no);
  Promotion selectOneByEmailPassword(Map<String,Object> valueMap);
  int insert(Promotion Promotion);
  int delete(int no);
  int update(Promotion Promotion);
void insertPhoto(HashMap<String, Object> valueMap);
void deletePhoto(int no);
}
