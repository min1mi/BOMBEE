package bitcamp.java93.domain;

import java.util.List;

public class Chat {
  List<String> noList;
  List<String> tnoList;
  int memberno;
  int trainerno;
  String arrivedate;
  String message;
  String yourName;
  String tPath;
  String mPath;
  String time;
  String pm;
  boolean confirm;
  int unread;
  int membertype;
  int mymno;
  int yourmno;
  public List<String> getNoList() {
    return noList;
  }
  public void setNoList(List<String> noList) {
    this.noList = noList;
  }
  public List<String> getTnoList() {
    return tnoList;
  }
  public void setTnoList(List<String> tnoList) {
    this.tnoList = tnoList;
  }
  public int getMemberno() {
    return memberno;
  }
  public void setMemberno(int memberno) {
    this.memberno = memberno;
  }
  public int getTrainerno() {
    return trainerno;
  }
  public void setTrainerno(int trainerno) {
    this.trainerno = trainerno;
  }
  public String getArrivedate() {
    return arrivedate;
  }
  public void setArrivedate(String arrivedate) {
    this.arrivedate = arrivedate;
  }
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }
  public String getYourName() {
    return yourName;
  }
  public void setYourName(String yourName) {
    this.yourName = yourName;
  }
  public String gettPath() {
    return tPath;
  }
  public void settPath(String tPath) {
    this.tPath = tPath;
  }
  public String getmPath() {
    return mPath;
  }
  public void setmPath(String mPath) {
    this.mPath = mPath;
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
  public boolean isConfirm() {
    return confirm;
  }
  public void setConfirm(boolean confirm) {
    this.confirm = confirm;
  }
  public int getUnread() {
    return unread;
  }
  public void setUnread(int unread) {
    this.unread = unread;
  }
  public int getMembertype() {
    return membertype;
  }
  public void setMembertype(int membertype) {
    this.membertype = membertype;
  }
  public int getMymno() {
    return mymno;
  }
  public void setMymno(int mymno) {
    this.mymno = mymno;
  }
  public int getYourmno() {
    return yourmno;
  }
  public void setYourmno(int yourmno) {
    this.yourmno = yourmno;
  }
  @Override
  public String toString() {
    return "Chat [noList=" + noList + ", tnoList=" + tnoList + ", memberno=" + memberno + ", trainerno=" + trainerno
        + ", arrivedate=" + arrivedate + ", message=" + message + ", yourName=" + yourName + ", tPath=" + tPath
        + ", mPath=" + mPath + ", time=" + time + ", pm=" + pm + ", confirm=" + confirm + ", unread=" + unread
        + ", membertype=" + membertype + ", mymno=" + mymno + ", yourmno=" + yourmno + "]";
  }
 
  
}
