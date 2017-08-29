package bitcamp.java93.domain;

import java.util.List;

public class Promotion extends Trainning {
  String titlePic;
	List <Trainning> promotionList;
	String titlePhoto;
  @Override
  public String toString() {
    return "Promotion [titlePic=" + titlePic + ", promotionList=" + promotionList + ", titlePhoto=" + titlePhoto
        + ", pno=" + pno + ", title=" + title + ", pric=" + pric + ", content=" + content + ", sdt=" + sdt + ", edt="
        + edt + ", lat=" + lat + ", lng=" + lng + ", meter=" + meter + ", photoList=" + photoList + ", expire=" + expire
        + ", comname=" + comname + ", zipcode=" + zipcode + ", comaddr=" + comaddr + ", comdetailaddr=" + comdetailaddr
        + ", spono=" + spono + ", introduction=" + introduction + ", tcherpic=" + tcherpic + ", tno=" + tno + ", no="
        + no + ", id=" + id + ", name=" + name + ", email=" + email + ", pwd=" + pwd + ", profilePicture="
        + profilePicture + ", membertype=" + membertype + ", accounttype=" + accounttype + "]";
  }
  public String getTitlePic() {
    return titlePic;
  }
  public void setTitlePic(String titlePic) {
    this.titlePic = titlePic;
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
	
	
}
