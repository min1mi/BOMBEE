package bitcamp.java93.dao;

import java.util.Map;

import bitcamp.java93.domain.Trainer;

public interface TrainerDao {
  int insert(Trainer trainer);
  Trainer selectOneByEmailPassword(Map<String,Object> valueMap);
}
