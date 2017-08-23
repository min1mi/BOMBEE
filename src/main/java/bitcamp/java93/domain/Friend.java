package bitcamp.java93.domain;

public class Friend {
  int no; // friendUpdate 요청시 trano를 담는 프로퍼티
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
  String date;
  String time;
  String pm;
  String title;
  String mPic;
  String tPic;
  int wishtime;
  boolean writerev;
  
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
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
  public String getDate() {
    return date;
  }
  public void setDate(String date) {
    this.date = date;
  }
  public String getTime() {
    return time;
  }
  public void setTime(String time) {
    this.time = time;
  }
  public String getPm() {
    return pm;
  }
  public void setPm(String pm) {
    this.pm = pm;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getmPic() {
    return mPic;
  }
  public void setmPic(String mPic) {
    this.mPic = mPic;
  }
  public String gettPic() {
    return tPic;
  }
  public void settPic(String tPic) {
    this.tPic = tPic;
  }
  public int getWishtime() {
    return wishtime;
  }
  public void setWishtime(int wishtime) {
    this.wishtime = wishtime;
  }
  @Override
  public String toString() {
    return "Friend [no=" + no + ", tno=" + tno + ", mno=" + mno + ", confirm=" + confirm + ", trano=" + trano + ", pno="
        + pno + ", period=" + period + ", sdt=" + sdt + ", edt=" + edt + ", mname=" + mname + ", tname=" + tname
        + ", date=" + date + ", time=" + time + ", pm=" + pm + ", title=" + title + ", mPic=" + mPic + ", tPic=" + tPic
        + ", wishtime=" + wishtime + "]";
  }
  
}
