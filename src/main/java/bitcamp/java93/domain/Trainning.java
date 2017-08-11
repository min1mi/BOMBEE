package bitcamp.java93.domain;

import java.util.List;

public class Trainning extends Trainer{
  int pno;
  String title;
  int pric;
  String content;
  String sdt;
  String edt;
  double lat;
  double lng;
  int meter;
  List <String> photoList;
  public int getPno() {
    return pno;
  }
  public void setPno(int pno) {
    this.pno = pno;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public int getPric() {
    return pric;
  }
  public void setPric(int pric) {
    this.pric = pric;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
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
  public double getLat() {
    return lat;
  }
  public void setLat(double lat) {
    this.lat = lat;
  }
  public double getLng() {
    return lng;
  }
  public void setLng(double lng) {
    this.lng = lng;
  }
  public int getMeter() {
    return meter;
  }
  public void setMeter(int meter) {
    this.meter = meter;
  }
  public List<String> getPhotoList() {
    return photoList;
  }
  public void setPhotoList(List<String> photoList) {
    this.photoList = photoList;
  }
  @Override
  public String toString() {
    return "Trainning [pno=" + pno + ", title=" + title + ", pric=" + pric + ", content=" + content + ", sdt=" + sdt
        + ", edt=" + edt + ", lat=" + lat + ", lng=" + lng + ", meter=" + meter + ", photoList=" + photoList
        + ", comname=" + comname + ", zipcode=" + zipcode + ", comaddr=" + comaddr + ", comdetailaddr=" + comdetailaddr
        + ", spono=" + spono + ", introduction=" + introduction + ", tno=" + tno + ", tcherpic=" + tcherpic + ", no="
        + no + ", id=" + id + ", name=" + name + ", email=" + email + ", pwd=" + pwd + ", membertype=" + membertype
        + ", accounttype=" + accounttype + "]";
  }

  
  
}
