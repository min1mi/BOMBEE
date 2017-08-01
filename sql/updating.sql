-- 식단 리스트 가져오기
select menupic, mealkcal, mealname, mealtype, date, confirm, day
from memb_manage
where date between '2017-07-30' and '2017-08-05'
