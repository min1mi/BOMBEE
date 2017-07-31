package bitcamp.java93.domain;

import java.util.List;

public class Promotion {
	int pno;
	List <Trainning> promotionList;
  public int getPno() {
    return pno;
  }
  public void setPno(int pno) {
    this.pno = pno;
  }
  public List<Trainning> getPtomotionList() {
    return promotionList;
  }
  public void setPtomotionList(List<Trainning> promotionList) {
    this.promotionList = promotionList;
  }
  @Override
  public String toString() {
    return "Promotion [pno=" + pno + ", promotionList=" + promotionList + "]";
  }


 
	
  
	
	
	
	
	
}
