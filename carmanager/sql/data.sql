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
insert into garage(mdno, mno, c_nick, mile, effi, trim) values(92, 1, '붕붕이', 14679, 14.5,''); 
insert into garage(mdno, mno, c_nick, mile, effi, trim) values(5, 1, '날썐돌이', 51825, 15.5,''); 
insert into garage(mdno, mno, c_nick, mile, effi, trim) values(20, 2, '엄마차', 2800, 14.1,''); 
insert into garage(mdno, mno, c_nick, mile, effi, trim) values(71, 2, '태웅차', 2800, 11.3,''); 
insert into garage(mdno, mno, c_nick, mile, effi, trim) values(200, 3, '재한차', 2800, 18.5,'');
insert into garage(mdno, mno, c_nick, mile, effi, trim) values(150, 4, '영호차', 1000, 11.3,''); 
insert into garage(mdno, mno, c_nick, mile, effi, trim) values(141, 5, '다인차', 1000, 18.5,''); 

-- 주유등록 (붕붕이) 휘발유
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(1, '2015-12-01', 12000, 40000, 29.48, 1357);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(1, '2015-12-07', 12420, 20000, 14.74, 1357);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(1, '2015-12-15', 12639, 30000, 22.11, 1357);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(1, '2015-12-24', 12955, 30000, 22.11, 1357);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(1, '2016-01-01', 13278, 15000, 11.06, 1357);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(1, '2016-01-09', 13439, 40000, 29.48, 1357);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(1, '2016-01-15', 13864, 30000, 22.11, 1357);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(1, '2016-01-26', 14187, 28000, 20.64, 1357);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(1, '2016-02-02', 14484, 18000, 13.27, 1357);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(1, '2016-02-10', 14679, 25000, 18.43, 1357);

-- 주유등록 (날썐돌이) 경유
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(2, '2015-12-02', 48000, 35000, 31.62, 1107);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(2, '2015-12-11', 48492, 23000, 20.78, 1107);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(2, '2015-12-20', 48812, 40000, 36.14, 1107);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(2, '2015-12-26', 49375, 30000, 27.11, 1107);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(2, '2016-01-06', 49796, 30000, 27.11, 1107);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(2, '2016-01-12', 50215, 20000, 18.07, 1107);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(2, '2016-01-17', 50497, 40000, 36.14, 1107);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(2, '2016-01-27', 51055, 25000, 22.59, 1107);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(2, '2016-02-02', 51404, 35000, 27.11, 1107);
insert into refuel(grno, ref_dt, mile, cost, liter, lcost) values(2, '2016-02-08', 51825, 25000, 22.59, 1107);


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

-- 게시판 더미 데이터 
insert into boards(mno, title, content, cre_dt, cate, photo) values(1, '하하하1', '1', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(2, '하하하2', '2', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(3, '하하하3', '3', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(4, '하하하4', '4', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(5, '하하하5', '5', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(1, '하하하6', '6', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(2, '하하하7', '7', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(3, '하하하8', '8', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(4, '하하하9', '9', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(5, '하하하10', '10', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(1, '하하하11', '11', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(2, '하하하12', '12', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(3, '하하하13', '13', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(4, '하하하14', '14', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(5, '하하하15', '15', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(1, '하하하16', '16', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(2, '하하하17', '17', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(3, '하하하18', '18', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(4, '하하하19', '19', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(5, '하하하20', '20', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(1, '하하하21', '21', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(2, '하하하22', '22', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(3, '하하하23', '23', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(4, '하하하24', '24', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(5, '하하하25', '25', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(1, '하하하26', '26', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(2, '하하하27', '27', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(3, '하하하28', '28', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(4, '하하하29', '29', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(5, '하하하30', '30', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(1, '하하하31', '31', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(2, '하하하32', '32', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(3, '하하하33', '33', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(4, '하하하34', '34', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(5, '하하하35', '35', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(1, '하하하36', '36', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(2, '하하하37', '37', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(3, '하하하38', '38', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(4, '하하하39', '39', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(5, '하하하40', '40', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(1, '하하하41', '41', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(2, '하하하42', '42', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(3, '하하하43', '43', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(4, '하하하44', '44', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(5, '하하하45', '45', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(1, '하하하46', '46', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(2, '하하하47', '47', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(3, '하하하48', '48', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(4, '하하하49', '49', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(5, '하하하50', '50', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(1, '하하하51', '51', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(2, '하하하52', '52', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(3, '하하하53', '53', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(4, '하하하54', '54', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(5, '하하하55', '55', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(1, '하하하56', '56', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(2, '하하하57', '57', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(3, '하하하58', '58', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(4, '하하하59', '59', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(5, '하하하60', '60', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(1, '하하하61', '61', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(2, '하하하62', '62', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(3, '하하하63', '63', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(4, '하하하64', '64', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(5, '하하하65', '65', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(1, '하하하66', '66', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(2, '하하하67', '67', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(3, '하하하68', '68', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(4, '하하하69', '69', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(5, '하하하70', '70', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(1, '하하하71', '71', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(2, '하하하72', '72', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(3, '하하하73', '73', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(4, '하하하74', '74', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(5, '하하하75', '75', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(1, '하하하76', '76', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(2, '하하하77', '77', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(3, '하하하78', '78', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(4, '하하하79', '79', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(5, '하하하80', '80', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(1, '하하하81', '81', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(2, '하하하82', '82', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(3, '하하하83', '83', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(4, '하하하84', '84', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(5, '하하하85', '85', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(1, '하하하86', '86', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(2, '하하하87', '87', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(3, '하하하88', '88', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(4, '하하하89', '89', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(5, '하하하90', '90', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(1, '하하하91', '91', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(2, '하하하92', '92', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(3, '하하하93', '93', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(4, '하하하94', '94', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(5, '하하하95', '95', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(1, '하하하96', '96', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(2, '하하하97', '97', now(), '자유', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(3, '하하하98', '98', now(), '소모품', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(4, '하하하99', '99', now(), '정비소', '../img/community/defaultImage.png');
insert into boards(mno, title, content, cre_dt, cate, photo) values(5, '하하하100', '100', now(), '자유', '../img/community/defaultImage.png');						

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

-- 댓글 테스트용
insert into comments(bno, mno, content, cre_dt) values('100', '5', '하하하하하1', now());
insert into comments(bno, mno, content, cre_dt) values('100', '4', '하하하하하2', now());
insert into comments(bno, mno, content, cre_dt) values('100', '3', '하하하하하3', now());
insert into comments(bno, mno, content, cre_dt) values('100', '2', '하하하하하4', now());
insert into comments(bno, mno, content, cre_dt) values('100', '1', '하하하하하5', now());

