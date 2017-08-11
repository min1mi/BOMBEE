package bitcamp.java93.domain;

public class Chat {
  int memberno;
  int trainerno;
  String arrivedate;
  String message;
  String yourName;

  boolean confirm;
  
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
  
  public boolean isConfirm() {
    return confirm;
  }
  public void setConfirm(boolean confirm) {
    this.confirm = confirm;
  }
  @Override
  public String toString() {
    return "Chat [memberno=" + memberno + ", trainerno=" + trainerno + ", arrivedate=" + arrivedate + ", message="
        + message + ", yourName=" + yourName + ", confirm=" + confirm + "]";
  }
  
  

}
