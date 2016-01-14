-- 회원정보 등록
insert into members(email, nick, pwd)
values('inpotin@naver.com', 'woong', '1111');
insert into members(email, nick, pwd)
values('hgal8877@naver.com', 'kijaha', '1111');
insert into members(email, nick, pwd)
values('ho4319@naver.com', 'hoho', '1111');
insert into members(email, nick, pwd)
values('dain@test.com', 'dain', '1111');

-- 회원 패스워드 암호화
update members set pwd=sha1(1111);



-- 내차등록
insert into garage(mdno, mno, c_nick, mile, effi) values(20, 1, '엄마차', 1000, 14.1); 
insert into garage(mdno, mno, c_nick, mile, effi) values(71, 2, '태웅차', 1000, 11.3); 
insert into garage(mdno, mno, c_nick, mile, effi) values(141, 3, '다인차', 1000, 18.5); 
insert into garage(mdno, mno, c_nick, mile, effi) values(150, 4, '영호차', 1000, 11.3); 
insert into garage(mdno, mno, c_nick, mile, effi) values(200, 1, '재한차', 1000, 18.5);

-- 주유등록 (엄마차)
insert into refuel(grno, ref_dt, mile, cost, liter) values(1, '2015-11-01', 1200, 30000, 20.13);
insert into refuel(grno, ref_dt, mile, cost, liter) values(1, '2015-11-04', 1400, 30000, 21.11);
insert into refuel(grno, ref_dt, mile, cost, liter) values(1, '2015-11-26', 1600, 30000, 21.23);
insert into refuel(grno, ref_dt, mile, cost, liter) values(1, '2015-12-05', 1900, 30000, 22.20);
insert into refuel(grno, ref_dt, mile, cost, liter) values(1, '2015-12-25', 2100, 30000, 23.03);
insert into refuel(grno, ref_dt, mile, cost, liter) values(1, '2016-01-07', 2200, 30000, 21.01);
insert into refuel(grno, ref_dt, mile, cost, liter) values(1, '2016-01-09', 2400, 30000, 20);
insert into refuel(grno, ref_dt, mile, cost, liter) values(1, '2016-01-14', 2800, 30000, 19.50);

-- 주유등록 (태웅차)
insert into refuel(grno, ref_dt, mile, cost, liter) values(2, '2015-11-01', 1200, 10000, 20.13);
insert into refuel(grno, ref_dt, mile, cost, liter) values(2, '2015-11-11', 1400, 35000, 15.11);
insert into refuel(grno, ref_dt, mile, cost, liter) values(2, '2015-11-29', 1600, 64000, 21.23);
insert into refuel(grno, ref_dt, mile, cost, liter) values(2, '2015-12-09', 1900, 10000, 10.20);
insert into refuel(grno, ref_dt, mile, cost, liter) values(2, '2015-12-15', 2100, 40000, 40.03);
insert into refuel(grno, ref_dt, mile, cost, liter) values(2, '2016-01-01', 2200, 36000, 21.01);
insert into refuel(grno, ref_dt, mile, cost, liter) values(2, '2016-01-09', 2400, 38000, 35);
insert into refuel(grno, ref_dt, mile, cost, liter) values(2, '2016-01-11', 2800, 39000, 26.50);

-- 주유등록 (재한차)
insert into refuel(grno, ref_dt, mile, cost, liter) values(5, '2015-11-5', 1200, 20000, 18.13);
insert into refuel(grno, ref_dt, mile, cost, liter) values(5, '2015-11-13', 1400, 30000, 17.11);
insert into refuel(grno, ref_dt, mile, cost, liter) values(5, '2015-11-27', 1600, 10000, 14.23);
insert into refuel(grno, ref_dt, mile, cost, liter) values(5, '2015-12-05', 1900, 40000, 25.20);
insert into refuel(grno, ref_dt, mile, cost, liter) values(5, '2015-12-12', 2100, 30000, 23.03);
insert into refuel(grno, ref_dt, mile, cost, liter) values(5, '2016-01-01', 2200, 20000, 15.01);
insert into refuel(grno, ref_dt, mile, cost, liter) values(5, '2016-01-06', 2400, 30000, 19.99);
insert into refuel(grno, ref_dt, mile, cost, liter) values(5, '2016-01-13', 2800, 60000, 19.50);



