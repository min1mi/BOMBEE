package bitcamp.java93.domain;

public class Trainning extends Trainer{
  int pno;
  String titl;
  int pric;
  String content;
  String sdt;
  String edt;
  int type;
  double lat;
  double lng;
  int meter;
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getTitl() {
		return titl;
	}
	public void setTitl(String titl) {
		this.titl = titl;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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
	@Override
	public String toString() {
		return "Trainning [pno=" + pno + ", titl=" + titl + ", pric=" + pric + ", content=" + content + ", sdt=" + sdt
				+ ", edt=" + edt + ", type=" + type + ", lat=" + lat + ", lng=" + lng + ", meter=" + meter + "]";
	}
  
  
  
  
}
