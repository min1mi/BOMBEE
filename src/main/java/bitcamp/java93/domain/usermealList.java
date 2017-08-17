package bitcamp.java93.domain;

public class usermealList {
  int trano;
  String sdt;
  String edt;
  boolean confirm;
  int mno;
  int tno;
  public int getTrano() {
    return trano;
  }
  public void setTrano(int trano) {
    this.trano = trano;
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
    return "usermealList [trano=" + trano + ", sdt=" + sdt + ", edt=" + edt + ", confirm=" + confirm + ", mno=" + mno
        + ", tno=" + tno + "]";
  }
  
  
  
  
  
}
