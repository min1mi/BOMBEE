package bitcamp.java93.domain;

import java.util.List;

public class Promotion extends Trainning{
	List <Trainning> promotionList;
	List <String> photoList;
	
	
  public List<Trainning> getPromotionList() {
    return promotionList;
  }

  public void setPromotionList(List<Trainning> promotionList) {
    this.promotionList = promotionList;
  }

  public List<String> getPhotoList() {
    return photoList;
  }

  public void setPhotoList(List<String> photoList) {
    this.photoList = photoList;
  }

  @Override
  public String toString() {
    return "Promotion [promotionList=" + promotionList + ", photoList=" + photoList + ", pno=" + pno + ", title="
        + title + ", pric=" + pric + ", content=" + content + ", sdt=" + sdt + ", edt=" + edt + ", lat=" + lat
        + ", lng=" + lng + ", meter=" + meter + ", comname=" + comname + ", zipcode=" + zipcode + ", comaddr=" + comaddr
        + ", comdetailaddr=" + comdetailaddr + ", spono=" + spono + ", introduction=" + introduction + ", tno=" + tno
        + ", tcherpic=" + tcherpic + ", no=" + no + ", id=" + id + ", name=" + name + ", email=" + email + ", pwd="
        + pwd + ", membertype=" + membertype + ", accounttype=" + accounttype + "]";
  }

  



  
  

 
	
  
	
	
	
	
	
}
