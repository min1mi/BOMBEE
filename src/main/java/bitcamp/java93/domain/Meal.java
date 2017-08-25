package bitcamp.java93.domain;

public class Meal {
  String mealtype;
  String mealpicture;
  String mealname;
  String mealkcal;
  Boolean confirm;
  int mealno;
  
  @Override
  public String toString() {
    return "Meal [mealtype=" + mealtype + ", mealpicture=" + mealpicture + ", mealname=" + mealname + ", mealkcal="
        + mealkcal + ", confirm=" + confirm + ", mealno=" + mealno + "]";
  }
  public String getMealtype() {
    return mealtype;
  }
  public void setMealtype(String mealtype) {
    this.mealtype = mealtype;
  }
  public String getMealpicture() {
    return mealpicture;
  }
  public void setMealpicture(String mealpicture) {
    this.mealpicture = mealpicture;
  }
  public String getMealname() {
    return mealname;
  }
  public void setMealname(String mealname) {
    this.mealname = mealname;
  }
  public String getMealkcal() {
    return mealkcal;
  }
  public void setMealkcal(String mealkcal) {
    this.mealkcal = mealkcal;
  }
  public Boolean getConfirm() {
    return confirm;
  }
  public void setConfirm(Boolean confirm) {
    this.confirm = confirm;
  }
  public int getMealno() {
    return mealno;
  }
  public void setMealno(int mealno) {
    this.mealno = mealno;
  }
  
  
  
}
