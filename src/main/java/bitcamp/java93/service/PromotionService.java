package bitcamp.java93.service;

import java.util.ArrayList;
import java.util.List;

import bitcamp.java93.domain.Location;
import bitcamp.java93.domain.Promotion;

public interface PromotionService {
  List<Promotion> list(Location local) throws Exception;
  List<Promotion> trainerList(Location local) throws Exception;
  Promotion get(int no) throws Exception;
  void add(Promotion promotion, int titleNo) throws Exception;
  void remove(int no) throws Exception;
  List<Promotion>  LatLonList(Location local) throws Exception;
  List<Promotion> nextList(int lastNo) throws Exception;
  List<Promotion> firstList() throws Exception;
  List<Promotion> healthNextList(int lastNo, int typeNo) throws Exception;
  List<Promotion> healthFirstList(int typeNo) throws Exception;
  List<Promotion> getPromotionList(int no) throws Exception;
  List<Promotion> getPromotionListTitle(int no) throws Exception;
  int deletePromotions(ArrayList<Integer> arr) throws Exception;
  void delAddImage(String delI) throws Exception;
	void updatePromotion(Promotion promotion, int titleNo) throws Exception;
  int deltePromotionImg(ArrayList<Integer> arr);
  int deletePromotionOne(int no) throws Exception;
	void titleImageInit(int pno);
	void updateTitlePic(String titleName);
}







