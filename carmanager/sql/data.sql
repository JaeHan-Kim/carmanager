-- 회원정보 등록
insert into members(email, nick, pwd)
values('kjh8877@naver.com', 'JaeHan', '1111');
insert into members(email, nick, pwd)
values('inpotin@naver.com', 'woong', '1111');
insert into members(email, nick, pwd)
values('hgal8877@hanmail.com', 'kijaha', '1111');
insert into members(email, nick, pwd)
values('ho4319@naver.com', 'hoho', '1111');
insert into members(email, nick, pwd)
values('dain@test.com', 'dain', '1111');
insert into members(email, nick, pwd)
values('flav5123@naver.com', '바른생활열이', '1111');
insert into members(email, nick, pwd)
values('ho4319@hanmail.com', '체리앤트리', '1111');
insert into members(email, nick, pwd)
values('eye2338@gmail.com', 'eye2338', '1111');
insert into members(email, nick, pwd)
values('rlawnsg@naver.com', 'rlawnsg', '1111');
insert into members(email, nick, pwd)
values('babozzzz@nate.com', 'babozzzz', '1111');
insert into members(email, nick, pwd)
values('krtitan@naver.com', 'krtitan', '1111');
insert into members(email, nick, pwd)
values('zzher@naver.com', '애밀안고효도르', '1111');
insert into members(email, nick, pwd)
values('doctac15@hanmail.net', 'TheDoct', '1111');
insert into members(email, nick, pwd)
values('tPro@gmail.com', '티프로', '1111');
insert into members(email, nick, pwd)
values('hooh4927@naver.com', 'BAUMERCE', '1111');
-- 회원 패스워드 암호화
update members set pwd=sha1(1111);



-- 내차등록
insert into garage(mdno, mno, c_nick, mile, effi, trim) values(92, 1, '붕붕이', 12770, 14.5,''); 
insert into garage(mdno, mno, c_nick, mile, effi, trim) values(5, 1, '날썐돌이', 77979, 15.5,''); 
insert into garage(mdno, mno, c_nick, mile, effi, trim) values(20, 2, '엄마차', 2800, 14.1,''); 
insert into garage(mdno, mno, c_nick, mile, effi, trim) values(71, 2, '태웅차', 2800, 11.3,''); 
insert into garage(mdno, mno, c_nick, mile, effi, trim) values(200, 3, '재한차', 2800, 18.5,'');
insert into garage(mdno, mno, c_nick, mile, effi, trim) values(150, 4, '영호차', 1000, 11.3,''); 
insert into garage(mdno, mno, c_nick, mile, effi, trim) values(141, 5, '다인차', 1000, 18.5,''); 

-- 주유등록 (붕붕이) 휘발유
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(1, '2015-11-02', 10000, 30000, 20.68, 1460);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(1, '2015-11-13', 10360, 50000, 31.84, 1570);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(1, '2015-11-26', 10860, 25000, 18.93, 1320);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(1, '2015-12-05', 11110, 30000, 25, 1200);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(1, '2015-12-16', 11440, 22050, 15, 1470);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(1, '2015-12-27', 11680, 50000, 34.24, 1460);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(1, '2016-01-05', 12180, 20000, 15.15, 1320);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(1, '2016-01-09', 12380, 40000, 28.98, 1380);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(1, '2016-01-19', 12770, 27000, 20, 1350);

-- 주유등록 (날썐돌이) 경유
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(2, '2015-11-01', 75000, 30000, 27.27, 1100);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(2, '2015-11-14', 75324, 50000, 41.66, 1200);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(2, '2015-11-24', 75824, 25000, 18.93, 1090);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(2, '2015-12-01', 76124, 48000, 40, 1200);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(2, '2015-12-19', 76604, 29000, 15, 1150);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(2, '2015-12-29', 76904, 50000, 40.45, 1236);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(2, '2016-01-01', 77360, 20000, 18.18, 1100);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(2, '2016-01-13', 77576, 40000, 33.89, 1180);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(2, '2016-01-20', 77979, 34500, 30, 1150);


-- 주유등록 (엄마차)
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(3, '2015-11-01', 1200, 30000, 20.13, 1380);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(3, '2015-11-04', 1400, 30000, 21.11, 1380);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(3, '2015-11-26', 1600, 30000, 21.23, 1380);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(3, '2015-12-05', 1900, 30000, 22.20, 1380);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(3, '2015-12-25', 2100, 30000, 23.03, 1380);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(3, '2016-01-07', 2200, 30000, 21.01, 1380);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(3, '2016-01-09', 2400, 30000, 20, 1380);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(3, '2016-01-14', 2800, 30000, 19.50, 1380);

-- 주유등록 (태웅차)
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(4, '2015-11-01', 1200, 10000, 20.13, 1380);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(4, '2015-11-11', 1400, 35000, 15.11, 1380);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(4, '2015-11-29', 1600, 64000, 21.23, 1380);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(4, '2015-12-09', 1900, 10000, 10.20, 1380);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(4, '2015-12-15', 2100, 40000, 40.03, 1380);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(4, '2016-01-01', 2200, 36000, 21.01, 1380);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(4, '2016-01-09', 2400, 38000, 35, 1380);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(4, '2016-01-11', 2800, 39000, 26.50, 1380);

-- 주유등록 (재한차)
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(5, '2015-11-5', 1200, 20000, 18.13, 1380);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(5, '2015-11-13', 1400, 30000, 17.11, 1380);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(5, '2015-11-27', 1600, 10000, 14.23, 1380);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(5, '2015-12-05', 1900, 40000, 25.20, 1380);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(5, '2015-12-12', 2100, 30000, 23.03, 1380);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(5, '2016-01-01', 2200, 20000, 15.01, 1380);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(5, '2016-01-06', 2400, 30000, 19.99, 1380);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(5, '2016-01-13', 2800, 60000, 19.50, 1380);

-- 소모품 등록
insert into goods(gname, l_mile) values('와이퍼 블레이드', 8000);
insert into goods(gname, l_mile) values('에어컨필터', 5000);
insert into goods(gname, l_mile) values('브레이크 패드', 30000);
insert into goods(gname, l_mile) values('브레이크 오일', 45000);
insert into goods(gname, l_mile) values('부동액', 40000);
insert into goods(gname, l_mile) values('엔진 오일', 10000);
insert into goods(gname, l_mile) values('미션 오일', 50000);
insert into goods(gname, l_mile) values('타이어', 60000);
insert into goods(gname, l_mile) values('배터리', 60000);