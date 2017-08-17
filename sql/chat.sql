insert into chat(tno, mno, confirm, msg, date, whosend)
      values(2, 1, false, 'aaa', '2017-08-16 15:45:11', 2);
insert into chat(tno, mno, confirm, msg, date, whosend)
      values(2, 1, false, 'aaa1', '2017-08-16 15:45:12', 2);
insert into chat(tno, mno, confirm, msg, date, whosend)
      values(2, 1, false, 'aaa2', '2017-08-16 15:45:13', 2);
insert into chat(tno, mno, confirm, msg, date, whosend)
      values(2, 1, false, 'aaa3', '2017-08-16 15:45:14', 2);
insert into chat(tno, mno, confirm, msg, date, whosend)
      values(2, 1, false, 'aaa4', '2017-08-16 15:45:15', 2);
insert into chat(tno, mno, confirm, msg, date, whosend)
      values(2, 1, false, 'aaa5', '2017-08-16 15:45:16', 2);
      
insert into chat(mno, tno, confirm, msg, date, whosend)
      values(1, 2, false, 'bbb', '2017-08-16 15:45:17', 1);
insert into chat(mno, tno, confirm, msg, date, whosend)
      values(1, 2, false, 'bbb1', '2017-08-16 15:45:18', 1);
insert into chat(mno, tno, confirm, msg, date, whosend)
      values(1, 2, false, 'bbb2', '2017-08-16 15:45:19', 1);
insert into chat(mno, tno, confirm, msg, date, whosend)
      values(1, 2, false, 'bbb3', '2017-08-16 15:45:20', 1);
insert into chat(mno, tno, confirm, msg, date, whosend) 
      values(1, 2, false, 'bbb4', '2017-08-16 15:45:21', 1);
insert into chat(mno, tno, confirm, msg, date, whosend)
      values(1, 2, false, 'bbb5', '2017-08-16 15:45:22', 1);
      

      
      
      
select cno, confirm, c.date, msg,
      c.tno as opponent, c.mno as user, whosend
      from chat c
      inner join tcher t on c.tno = t.tno
      where c.mno = 1 and c.tno = 2