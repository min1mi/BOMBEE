package bitcamp.java93.service;


import java.util.List;

import bitcamp.java93.domain.Promotion;
import bitcamp.java93.domain.Trainer;

public interface TrainerService {
  /*read-only : list, get*/
  void add(Trainer trainer) throws Exception;
  Trainer getByEmailPassword(String id, String pwd) throws Exception;
  Trainer get(int no) throws Exception;
  void update(Trainer trainer) throws Exception;
  List<Promotion> getPromotionList(int no) throws Exception;
}
