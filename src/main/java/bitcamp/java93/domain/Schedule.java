package bitcamp.java93.domain;

import java.util.List;

public class Schedule extends Day {
  
  int tno;
  List <Day> weeklist;
  public int getTno() {
    return tno;
  }
  public void setTno(int tno) {
    this.tno = tno;
  }
  public List<Day> getWeeklist() {
    return weeklist;
  }
  public void setWeeklist(List<Day> weeklist) {
    this.weeklist = weeklist;
  }
  @Override
  public String toString() {
    return "Schedule [tno=" + tno + ", weeklist=" + weeklist + ", schno=" + schno + ", day=" + day + ", time=" + time
        + "]";
  }
 
  
}
