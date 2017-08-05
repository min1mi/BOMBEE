package bitcamp.java93.domain;

import java.util.List;

/* 역할: memb 테이블의 값을 보관할 때 사용할 클래스
 * => 복합 데이터를 다룰 때, 이렇게 클래스를 정의하여 사용한다.
 * => 이런 복합 데이터를 보관하는 용도로 사용하는 클래스를
 *    "도메인(domain)" 클래스 또는 "DTO(Data Transfer Object)"라 부른다.
 */


public class Usermeal extends Meal{
  int no;
  List<Meal> meal;
  String date;
  String day;
  Boolean confirm;


  
  @Override
  public String toString() {
    return "Usermeal [no=" + no + ", meal=" + meal + ", date=" + date + ", day=" + day + ", confirm=" + confirm
        + ", mealtype=" + mealtype + ", mealpicture=" + mealpicture + ", mealname=" + mealname + ", mealkcal="
        + mealkcal + "]";
  }
  
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public List<Meal> getMeal() {
    return meal;
  }
  public void setMeal(List<Meal> meal) {
    this.meal = meal;
  }
  public String getDate() {
    return date;
  }
  public void setDate(String date) {
    this.date = date;
  }
  public String getDay() {
    return day;
  }
  public void setDay(String day) {
    this.day = day;
  }
  public Boolean getConfirm() {
    return confirm;
  }
  public void setConfirm(Boolean confirm) {
    this.confirm = confirm;
  }

  
  
}
