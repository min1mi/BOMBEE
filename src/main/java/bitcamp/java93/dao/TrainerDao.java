package bitcamp.java93.dao;

import java.util.Map;

import bitcamp.java93.domain.Trainer;

public interface TrainerDao {
  int insert(Trainer trainer);
  Trainer selectOneByEmailPassword(Map<String,Object> valueMap);
  Trainer selectOne(int no);
  Trainer selectOne2(int no);
  int update(Trainer trainer);
}
