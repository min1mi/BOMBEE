package bitcamp.java93.domain;

public class Friend {
  
  int tno;
  int mno;
  boolean confirm;
  int trano;
  int pno;
  int period;
  String sdt;
  String edt;
  String mname;
  String tname;
  int wishtime;
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
  public int getPeriod() {
    return period;
  }
  public void setPeriod(int period) {
    this.period = period;
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
  public String getMname() {
    return mname;
  }
  public void setMname(String mname) {
    this.mname = mname;
  }
  public String getTname() {
    return tname;
  }
  public void setTname(String tname) {
    this.tname = tname;
  }
  public int getWishtime() {
    return wishtime;
  }
  public void setWishtime(int wishtime) {
    this.wishtime = wishtime;
  }
  @Override
  public String toString() {
    return "Friend [tno=" + tno + ", mno=" + mno + ", confirm=" + confirm + ", trano=" + trano + ", pno=" + pno
        + ", period=" + period + ", sdt=" + sdt + ", edt=" + edt + ", mname=" + mname + ", tname=" + tname
        + ", wishtime=" + wishtime + "]";
  }
  
  
  
}
