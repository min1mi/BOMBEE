-- member 등록
insert into memb(id, email, accounttype, pwd, name, mtype)
values('star12310', 'star12310', '1', password('1111'), '권봉수1', '2');
insert into memb(id, email, accounttype, pwd, name, mtype)
values('star12311', 'star12311', '1', password('1111'), '권봉수2', '2');
insert into memb(id, email, accounttype, pwd, name, mtype)
values('star12312', 'star12312', '1', password('1111'), '권봉수3', '2');
insert into memb(id, email, accounttype, pwd, name, mtype)
values('star12313', 'star12313', '1', password('1111'), '권봉수4', '2');
insert into memb(id, email, accounttype, pwd, name, mtype)
values('star12314', 'star12314', '1', password('1111'), '권봉수5', '2');
insert into memb(id, email, accounttype, pwd, name, mtype)
values('star12315', 'star12315', '1', password('1111'), '권봉수6', '2');
insert into memb(id, email, accounttype, pwd, name, mtype)
values('star12316', 'star12316', '1', password('1111'), '권봉수7', '2');
insert into memb(id, email, accounttype, pwd, name, mtype)
values('star12317', 'star12317', '1', password('1111'), '권봉수8', '2');
insert into memb(id, email, accounttype, pwd, name, mtype)
values('star12318', 'star12318', '1', password('1111'), '권봉수9', '2');
insert into memb(id, email, accounttype, pwd, name, mtype)
values('star12319', 'star12319', '1', password('1111'), '권봉수0', '2');
insert into memb(id, email, accounttype, pwd, name, mtype)
values('11', '11', '1', password('1111'), '이윤민', '1');
insert into memb(id, email, accounttype, pwd, name, mtype)
values('22', '22', '1', password('1111'), '양승열', '1');
insert into memb(id, email, accounttype, pwd, name, mtype)
values('33', '33', '1', password('1111'), '순민이형', '1');
insert into memb(id, email, accounttype, pwd, name, mtype)
values('44', '44', '1', password('1111'), '김승민', '1');
insert into memb(id, email, accounttype, pwd, name, mtype)
values('55', '55', '1', password('1111'), '박규호', '1');
insert into memb(id, email, accounttype, pwd, name, mtype)
values('66', '66', '1', password('1111'), '규호', '1');

insert into tcher(tno, company, comaddr, zipcode, comdetailaddr, introduction, spono)
values(1, ' ', '서울특별시 서초구 서초2동 1327-33', ' ', ' '  ,'최고의 트레이너', 1);
insert into tcher(tno, company, comaddr, zipcode, comdetailaddr, introduction, spono)
values(2, ' ', '서울특별시 서초구 서초동 1327-15', ' ', ' ' ,'최고의 트레이너', 2);
insert into tcher(tno, company, comaddr, zipcode, comdetailaddr, introduction, spono)
values(3, ' ', '서울특별시 서초구 서운로 115', ' ', ' '  ,'최고의 트레이너', 3);
insert into tcher(tno, company, comaddr, zipcode, comdetailaddr, introduction, spono)
values(4, ' ', '서울특별시 서초구 서초대로74길 11', ' ', ' '  ,'최고의 트레이너', 4);
insert into tcher(tno, company, comaddr, zipcode, comdetailaddr, introduction, spono)
values(5, ' ', '서울특별시 강남구 테헤란로 114', ' ', ' '  ,'최고의 트레이너', 1);
insert into tcher(tno, company, comaddr, zipcode, comdetailaddr, introduction, spono)
values(6, ' ', '서울특별시 서초구 강남대로 369', ' ', ' '  ,'최고의 트레이너', 2);
insert into tcher(tno, company, comaddr, zipcode, comdetailaddr, introduction, spono)
values(7, ' ', '서울특별시 강남구 역삼로 114', ' ', ' '  ,'최고의 트레이너', 3);
insert into tcher(tno, company, comaddr, zipcode, comdetailaddr, introduction, spono)
values(8, ' ', '서울특별시 강남구 강남대로 354', ' ', ' '  ,'최고의 트레이너', 4);
insert into tcher(tno, company, comaddr, zipcode, comdetailaddr, introduction, spono)
values(9, ' ', '서울특별시 서초구 서초대로74길 51 ', ' ', ' '  ,'최고의 트레이너', 1);
insert into tcher(tno, company, comaddr, zipcode, comdetailaddr, introduction, spono)
values(10, ' ', '서울특별시 서초구 서운로 79', ' ', ' '  ,'최고의 트레이너', 2);




-- 개인 트레이너 추가
insert into tcher_trainer(mno, tno, sdt, edt, confirm, pno)
values(1, 2, curdate(), date_add(curdate(), interval 30 day), 1, 1);
insert into tcher_trainer(mno, tno, sdt, edt, confirm, pno)
values(1, 2, curdate(), date_add(curdate(), interval 30 day), 1, 2);
insert into tcher_trainer(mno, tno, sdt, edt, confirm, pno)
values(1, 2, curdate(), date_add(curdate(), interval 30 day), 1, 3);
insert into tcher_trainer(mno, tno, sdt, edt, confirm, pno)
values(1, 2, curdate(), date_add(curdate(), interval 30 day), 1, 4);


--  프로모션 추가
insert into promotion(titl, content, tno, sdt, edt, lat, lng, pric)
values('헬스헬스헬스', '헬스헬스헬스헬스헬스헬스', '1',  '2017-07-01', '2017-07-30' ,37.4946112534, 127.0275783148, 50000);
insert into promotion(titl, content, tno, sdt, edt, lat, lng, pric)
values('스피닝스피닝', '스피닝스피닝스피닝스피닝', '2',  '2017-07-01', '2017-07-30' ,37.4945354656, 127.0280170427, 50000);
insert into promotion(titl, content, tno, sdt, edt, lat, lng, pric)
values('요가요가요가', '요가요가요가요가요가요가', '3',  '2017-07-01', '2017-07-30' ,37.4939487828, 127.0245384676, 50000);
insert into promotion(titl, content, tno, sdt, edt, lat, lng, pric)
values('필라필라필라', '필라테스필라테스필라테스', '4',  '2017-07-01', '2017-07-30' ,37.4966332658, 127.0269141213, 50000);
insert into promotion(titl, content, tno, sdt, edt, lat, lng, pric)
values('헬스헬스헬스', '헬스헬스헬스헬스헬스헬스', '5',  '2017-07-01', '2017-07-30' ,37.4982867439, 127.0301037691, 50000);
insert into promotion(titl, content, tno, sdt, edt, lat, lng, pric)
values('스피닝스피닝', '스피닝스피닝스피닝스피닝', '6',  '2017-07-01', '2017-07-30' ,37.4956598746, 127.028216489, 50000);
insert into promotion(titl, content, tno, sdt, edt, lat, lng, pric)
values('요가요가요가', '요가요가요가요가요가요가', '7',  '2017-07-01', '2017-07-30' ,37.493211869, 127.0316531812, 50000);
insert into promotion(titl, content, tno, sdt, edt, lat, lng, pric)
values('필라필라필라', '필라테스필라테스필라테스', '8',  '2017-07-01', '2017-07-30' ,37.4946503754, 127.029731402, 50000);
insert into promotion(titl, content, tno, sdt, edt, lat, lng, pric)
values('헬스헬스헬스', '헬스헬스헬스헬스헬스헬스', '9',  '2017-07-01', '2017-07-30' ,37.4930613264, 127.0284009612, 50000);
insert into promotion(titl, content, tno, sdt, edt, lat, lng, pric)
values('스피닝스피닝', '스피닝스피닝스피닝스피닝', '10', '2017-07-01', '2017-07-30' ,37.490643365, 127.0269391101, 50000);
