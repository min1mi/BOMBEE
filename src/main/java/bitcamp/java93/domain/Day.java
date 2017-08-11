package bitcamp.java93.domain;

import java.util.List;

public class Day {
 
  int schno;
  String day;
  String time;
  public int getSchno() {
    return schno;
  }
  public void setSchno(int schno) {
    this.schno = schno;
  }
  public String getDay() {
    return day;
  }
  public void setDay(String day) {
    this.day = day;
  }
  public String getTime() {
    return time;
  }
  public void setTime(String time) {
    this.time = time;
  }
  @Override
  public String toString() {
    return "Day [schno=" + schno + ", day=" + day + ", time=" + time + "]";
  }
  
  
  
  
}
