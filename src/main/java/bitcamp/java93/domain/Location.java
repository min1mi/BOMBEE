package bitcamp.java93.domain;

public class Location {
  double lat;
  double lon;
  int teacherOrPromotion;
  public double getLat() {
    return lat;
  }
  public void setLat(double lat) {
    this.lat = lat;
  }
  public double getLon() {
    return lon;
  }
  public void setLon(double lon) {
    this.lon = lon;
  }

  public int getTeacherOrPromotion() {
    return teacherOrPromotion;
  }
  public void setTeacherOrPromotion(int teacherOrPromotion) {
    this.teacherOrPromotion = teacherOrPromotion;
  }
  @Override
  public String toString() {
    return "Location [lat=" + lat + ", lon=" + lon + ", teacherOrPromotion=" + teacherOrPromotion + "]";
  }

  
  
  
  
}
