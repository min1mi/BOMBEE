select menupic, mealkcal, mealname, mealtype, date, confirm, day
from memb_manage
where date between #{startDate} and #{endDate}
