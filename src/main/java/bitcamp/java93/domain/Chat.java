package bitcamp.java93.domain;

public class Chat {
  int memberno;
  int trainerno;
  String date;
  String message;
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
  public String getDate() {
    return date;
  }
  public void setDate(String date) {
    this.date = date;
  }
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }
  public boolean isConfirm() {
    return confirm;
  }
  public void setConfirm(boolean confirm) {
    this.confirm = confirm;
  }
  @Override
  public String toString() {
    return "Chat [memberno=" + memberno + ", trainerno=" + trainerno + ", date=" + date + ", message=" + message
        + ", confirm=" + confirm + "]";
  }
  
}
