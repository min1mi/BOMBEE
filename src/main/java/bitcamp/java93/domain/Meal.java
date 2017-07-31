package bitcamp.java93.domain;

public class Meal {
  String mealtype;
  String menupicture;
  String mealname;
  String mealkcal;
  public String getMealtype() {
    return mealtype;
  }
  public void setMealtype(String mealtype) {
    this.mealtype = mealtype;
  }
  public String getMenupicture() {
    return menupicture;
  }
  public void setMenupicture(String menupicture) {
    this.menupicture = menupicture;
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
  @Override
  public String toString() {
    return "Meal [mealtype=" + mealtype + ", menupicture=" + menupicture + ", mealname=" + mealname + ", mealkcal="
        + mealkcal + "]";
  }
  
  
}
