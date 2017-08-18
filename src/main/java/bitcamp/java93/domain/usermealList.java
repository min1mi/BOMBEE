package bitcamp.java93.domain;

public class usermealList {
  int trano;
  int pno;
  String sdt;
  String edt;
  String tName;
  String promotionTitle;
  String proImg;
  boolean confirm;
  int mno;
  int tno;
  public int getTrano() {
    return trano;
  }
  public void setTrano(int trano) {
    this.trano = trano;
  }
  public int getPno() {
    return pno;
  }
  public void setPno(int pno) {
    this.pno = pno;
  }
  public String getSdt() {
    return sdt;
  }
  public void setSdt(String sdt) {
    this.sdt = sdt;
  }
  public String getEdt() {
    return edt;
  }
  public void setEdt(String edt) {
    this.edt = edt;
  }
  public String gettName() {
    return tName;
  }
  public void settName(String tName) {
    this.tName = tName;
  }
  public String getPromotionTitle() {
    return promotionTitle;
  }
  public void setPromotionTitle(String promotionTitle) {
    this.promotionTitle = promotionTitle;
  }
  public String getProImg() {
    return proImg;
  }
  public void setProImg(String proImg) {
    this.proImg = proImg;
  }
  public boolean isConfirm() {
    return confirm;
  }
  public void setConfirm(boolean confirm) {
    this.confirm = confirm;
  }
  public int getMno() {
    return mno;
  }
  public void setMno(int mno) {
    this.mno = mno;
  }
  public int getTno() {
    return tno;
  }
  public void setTno(int tno) {
    this.tno = tno;
  }
  @Override
  public String toString() {
    return "usermealList [trano=" + trano + ", pno=" + pno + ", sdt=" + sdt + ", edt=" + edt + ", tName=" + tName
        + ", promotionTitle=" + promotionTitle + ", proImg=" + proImg + ", confirm=" + confirm + ", mno=" + mno
        + ", tno=" + tno + "]";
  }
  
}
