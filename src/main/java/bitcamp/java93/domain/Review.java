package bitcamp.java93.domain;


public class Review{
  
  int reviewno;
  int trano;
  int score;
  String review;
  int mno;
  String name;
  int tno;
  int pno;
  String sdt;
  String edt;
  double avg;
  boolean writerev;
  String proTitle;
  String date;
  public int getReviewno() {
    return reviewno;
  }
  public void setReviewno(int reviewno) {
    this.reviewno = reviewno;
  }
  public int getTrano() {
    return trano;
  }
  public void setTrano(int trano) {
    this.trano = trano;
  }
  public int getScore() {
    return score;
  }
  public void setScore(int score) {
    this.score = score;
  }
  public String getReview() {
    return review;
  }
  public void setReview(String review) {
    this.review = review;
  }
  public int getMno() {
    return mno;
  }
  public void setMno(int mno) {
    this.mno = mno;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getTno() {
    return tno;
  }
  public void setTno(int tno) {
    this.tno = tno;
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
  public double getAvg() {
    return avg;
  }
  public void setAvg(double avg) {
    this.avg = avg;
  }
  public boolean isWriterev() {
    return writerev;
  }
  public void setWriterev(boolean writerev) {
    this.writerev = writerev;
  }
  public String getProTitle() {
    return proTitle;
  }
  public void setProTitle(String proTitle) {
    this.proTitle = proTitle;
  }
  public String getDate() {
    return date;
  }
  public void setDate(String date) {
    this.date = date;
  }
  @Override
  public String toString() {
    return "Review [reviewno=" + reviewno + ", trano=" + trano + ", score=" + score + ", review=" + review + ", mno="
        + mno + ", name=" + name + ", tno=" + tno + ", pno=" + pno + ", sdt=" + sdt + ", edt=" + edt + ", avg=" + avg
        + ", writerev=" + writerev + ", proTitle=" + proTitle + ", date=" + date + "]";
  }
}
