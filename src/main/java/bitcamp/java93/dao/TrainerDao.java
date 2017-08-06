package bitcamp.java93.dao;

import java.util.List;
import java.util.Map;

import bitcamp.java93.domain.Promotion;
import bitcamp.java93.domain.Trainer;

public interface TrainerDao {
  int insert(Trainer trainer);
  Trainer selectOneByEmailPassword(Map<String,Object> valueMap);
  Trainer selectOne(int no);
  int update(Trainer trainer);
  List<Promotion> selectPromotionList(int no);
}
