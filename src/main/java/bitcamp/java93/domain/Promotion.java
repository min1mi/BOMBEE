package bitcamp.java93.domain;

import java.util.List;

public class Promotion extends Trainning{
	List <Trainning> promotionList;
	String titlePhoto;
	
	
	
  public String getTitlePhoto() {
    return titlePhoto;
  }

  public void setTitlePhoto(String titlePhoto) {
    this.titlePhoto = titlePhoto;
  }

  public List<Trainning> getPromotionList() {
    return promotionList;
  }

  public void setPromotionList(List<Trainning> promotionList) {
    this.promotionList = promotionList;
  }

  @Override
  public String toString() {
    return "Promotion [promotionList=" + promotionList + ", titlePhoto=" + titlePhoto + ", pno=" + pno + ", title="
        + title + ", pric=" + pric + ", content=" + content + ", sdt=" + sdt + ", edt=" + edt + ", lat=" + lat
        + ", lng=" + lng + ", meter=" + meter + ", photoList=" + photoList + ", comname=" + comname + ", zipcode="
        + zipcode + ", comaddr=" + comaddr + ", comdetailaddr=" + comdetailaddr + ", spono=" + spono + ", introduction="
        + introduction + ", tno=" + tno + ", tcherpic=" + tcherpic + ", no=" + no + ", id=" + id + ", name=" + name
        + ", email=" + email + ", pwd=" + pwd + ", membertype=" + membertype + ", accounttype=" + accounttype + "]";
  }


  
	
	
	
}
