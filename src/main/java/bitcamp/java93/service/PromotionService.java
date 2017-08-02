package bitcamp.java93.service;

import java.util.List;

import bitcamp.java93.domain.Location;
import bitcamp.java93.domain.Promotion;

public interface PromotionService {
  List<Promotion> list(Location local) throws Exception;
  List<Promotion> trainerList(Location local) throws Exception;
  Promotion get(int no) throws Exception;
  void add(Promotion promotion) throws Exception;
  void remove(int no) throws Exception;
  List<Promotion>  LatLonList(Location local) throws Exception;
}







