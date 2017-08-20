package bitcamp.java93.domain;

public class Friend {
  
  int tno;
  int mno;
  boolean confirm;
  int trano;
  int pno;
  String sdt;
  String name;
  public int getTno() {
    return tno;
  }
  public void setTno(int tno) {
    this.tno = tno;
  }
  public int getMno() {
    return mno;
  }
  public void setMno(int mno) {
    this.mno = mno;
  }
  public boolean isConfirm() {
    return confirm;
  }
  public void setConfirm(boolean confirm) {
    this.confirm = confirm;
  }
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
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  @Override
  public String toString() {
    return "Friend [tno=" + tno + ", mno=" + mno + ", confirm=" + confirm + ", trano=" + trano + ", pno=" + pno
        + ", sdt=" + sdt + ", name=" + name + "]";
  }
  
  
  
}
