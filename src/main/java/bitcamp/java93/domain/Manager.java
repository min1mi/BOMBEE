package bitcamp.java93.domain;


public class Manager extends Member {
  String position;
  String fax;
  String path;

  
  @Override
  public String toString() {
    return "Manager [no=" + no + ", name=" + name + ", tel=" + tel + ", email=" + email + ", position=" + position
        + ", fax=" + fax + ", path=" + path + ", password=" + password + "]";
  }

  public String getPosition() {
    return position;
  }


  public void setPosition(String position) {
    this.position = position;
  }


  public String getFax() {
    return fax;
  }


  public void setFax(String fax) {
    this.fax = fax;
  }


  public String getPath() {
    return path;
  }


  public void setPath(String path) {
    this.path = path;
  }  
  
}
