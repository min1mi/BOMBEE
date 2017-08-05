package bitcamp.java93.domain;

public class Meal {
  String mealtype;
  String mealpicture;
  String mealname;
  String mealkcal;
  
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
  @Override
  public String toString() {
    return "Meal [mealtype=" + mealtype + ", mealpicture=" + mealpicture + ", mealname=" + mealname + ", mealkcal="
        + mealkcal + "]";
  }
  
  
}
