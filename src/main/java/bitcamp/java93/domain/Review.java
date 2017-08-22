package bitcamp.java93.domain;

public class Review{
  
  int score;
  int reviewno;
  String review;
  String name;
  int mno;
  int trano;
  public int getScore() {
    return score;
  }
  public void setScore(int score) {
    this.score = score;
  }
  public int getReviewno() {
    return reviewno;
  }
  public void setReviewno(int reviewno) {
    this.reviewno = reviewno;
  }
  public String getReview() {
    return review;
  }
  public void setReview(String review) {
    this.review = review;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getMno() {
    return mno;
  }
  public void setMno(int mno) {
    this.mno = mno;
  }
  public int getTrano() {
    return trano;
  }
  public void setTrano(int trano) {
    this.trano = trano;
  }
  @Override
  public String toString() {
    return "Review [score=" + score + ", reviewno=" + reviewno + ", review=" + review + ", name=" + name + ", mno="
        + mno + ", trano=" + trano + "]";
  }
  
  
  
  
  
  
  
}
