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

  boolean confirm;

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

  public boolean isConfirm() {
    return confirm;
  }

  public void setConfirm(boolean confirm) {
    this.confirm = confirm;
  }

  @Override
  public String toString() {
    return "Chat [noList=" + noList + ", tnoList=" + tnoList + ", memberno=" + memberno + ", trainerno=" + trainerno
        + ", arrivedate=" + arrivedate + ", message=" + message + ", yourName=" + yourName + ", tPath=" + tPath
        + ", mPath=" + mPath + ", confirm=" + confirm + "]";
  }

 
}
