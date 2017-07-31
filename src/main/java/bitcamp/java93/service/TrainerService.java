package bitcamp.java93.service;

import bitcamp.java93.domain.Trainer;

public interface TrainerService {
  /*read-only : list, get*/
  void add(Trainer trainer) throws Exception;
  Trainer getByEmailPassword(String email, String password, int membertype) throws Exception;
  Trainer get(int no) throws Exception;
}
