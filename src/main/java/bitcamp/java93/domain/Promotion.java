package bitcamp.java93.domain;

import java.util.List;

public class Promotion extends Trainning {
  String titlePic;
  String tiPic;
	List <Trainning> promotionList;
	String titlePhoto;
	
  public String getTitlePic() {
    return titlePic;
  }
  public void setTitlePic(String titlePic) {
    this.titlePic = titlePic;
  }
  public String getTiPic() {
    return tiPic;
  }
  public void setTiPic(String tiPic) {
    this.tiPic = tiPic;
  }
  public List<Trainning> getPromotionList() {
    return promotionList;
  }
  public void setPromotionList(List<Trainning> promotionList) {
    this.promotionList = promotionList;
  }
  public String getTitlePhoto() {
    return titlePhoto;
  }
  public void setTitlePhoto(String titlePhoto) {
    this.titlePhoto = titlePhoto;
  }
  @Override
  public String toString() {
    return "Promotion [titlePic=" + titlePic + ", tiPic=" + tiPic + ", promotionList=" + promotionList + ", titlePhoto="
        + titlePhoto + ", pno=" + pno + ", title=" + title + ", pric=" + pric + ", content=" + content + ", sdt=" + sdt
        + ", edt=" + edt + ", lat=" + lat + ", lng=" + lng + ", meter=" + meter + ", photoList=" + photoList
        + ", comname=" + comname + ", zipcode=" + zipcode + ", comaddr=" + comaddr + ", comdetailaddr=" + comdetailaddr
        + ", spono=" + spono + ", introduction=" + introduction + ", tno=" + tno + ", no=" + no + ", id=" + id
        + ", name=" + name + ", email=" + email + ", pwd=" + pwd + ", profilePicture=" + profilePicture
        + ", membertype=" + membertype + ", accounttype=" + accounttype + "]";
  }

  
	
	
	
	
}
