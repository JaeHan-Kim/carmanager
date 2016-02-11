-- 게시물 1번

insert into boards(mno, title, content, cre_dt, cate, photo) 
values(1, 
     '카센터.. 어디를 가시나요? 협력점? 아님 일반 카센터?', 
       '<p>지금 차는 기아 2005년식 쏘렌토입니다.</p><br><p>1년에 몇 번은 소모품 교체겸 해서 카센터 가는데.. 마땅한 곳이 없어 그냥 오토큐 가고 있네요.</p><br><p>전에 다니던 카센터는 일반 카센터인데 10년 가까이 다녀서 사장님도 친절하시고 좋았었는데 그 자리에 아파트 들어서면서 없어졌네요. 사장님이 다른 곳에서 카센터 또 하심 좋은데 그게 아니라서..쩝..</p><br><p>지금 제가 가고 있는 오토큐는.. 오일을 갈거나 부동액을 갈거나 할때 제가 사갖고 가서 갈아달라고 하면 공임만 받고 해 주긴 합니다. 한데 공임이 좀 비싸다고들 말하고..</p><br><p>일반 카센터 가도 제가 오일을 사갖고 가서 이걸로 갈아달라고 하면 갈아주나요? 아무래도 기분나빠 할 듯 한데요.</p><br><p>스피드 메이트는 예전에 몇 번 가봤는데 좀 아닌것 같고.. 사실 제가 핸드폰을 sk 쓰는지라 멤버쉽카드로 할인 받으러 갔던..  단순히 할인이 목적이었죠. ㅋㅋ 근데 거긴 좀 아닌것 같더라구요.</p><br><p>이번 주에 엔진오일 교체하려고 하는데 부동액도 교체한지 35,000km가 넘어서  부동액도 같이 교체할까 싶어 오토큐에 부동액 교체비용 물어봤더니 55,000원 말하네요. 제 쏘렌토가 원래 이 정도 금액 하나요??</p><br>', 
     now(), 
     '정비소', 
     '../img/community/defaultImage.png'
     );
     
   
insert into comments(bno, mno, content, cre_dt) values('1', '2', '작업방법에 따라 틀리지요.', now());

insert into comments(bno, mno, content, cre_dt) values('1', '3', '기분 나빠하고 나사산 망가뜨릴 수도 있어요..', now());

insert into comments(bno, mno, content, cre_dt) values('1', '4', '부동액 순환식으로 교체해 주는 곳 갔는데, 부가세 포함해서 9만 원 정도였어요. 순환식 교체도 아닌데 5만5천 원 낼 바엔, 차라리 순환식으로 하는 곳 가는 곳이 좋을 것 같네요.네이버 블로그 검색하면 업체가 나와요~', now());

insert into comments(bno, mno, content, cre_dt) values('1', '5', '그닥 싫어하지는 않으시는것같던뎅... 그래도 사가는걸 그렇게 막 좋아하진 않겠쥬 ㅎㅎ', now());

insert into comments(bno, mno, content, cre_dt) values('1', '6', 'ㅎㅎㅎ', now());

insert into comments(bno, mno, content, cre_dt) values('1', '7', '음', now());


-- 게시물 2번

insert into boards(mno, title, content, cre_dt, cate, photo) 
values(2, 
     '스포티지R 와이퍼 HG 그랜저 와이퍼로 교체ㅎ', 
       '<p>오늘 퇴근길 비가오는데..와이퍼가 잘 안닦이지 말입니다.</p>
<p>오면서 현대모비스 부품대리점에 들러 hg 그랜저 전면 와이퍼 한조 구입(19,800원)</p>
<p><img src="../img/community/2-1.jpg" style="width:467px;"></p><br>
<p>운전석 쪽 와이퍼가 스포티지R 순정이 600mm이고 hg</p>
<p>그랜저 순정이 650mm이지만 아슬아슬하기 사이즈가 딱 나오네요</p>
<p>간격이 없는 만큼 와이퍼가 빈틈없이 잘닦입니다. ㅎ</p>
<p>딱봐도 훨씬 고급스럽게 생겼고 뭔가 더 잘 닦일것 같은 플라시보효과 ㅎㅎ</p>
<p><img src="../img/community/2-2.jpg" style="width:467px;"></p><br>
<p><img src="../img/community/2-3.jpg" style="width:467px;"></p><br>
<p>완제품은 hg그랜저가 yf 소나타보다 쌉니다.</p>
<p>뒤쪽 리어 와이퍼는 스포티지R 전용 와이퍼보다</p><br>
<p>투싼ix와이퍼가 절반 가격이니 참고하세요</p>', 
     now(), 
     '소모품', 
     '../img/community/2-1.jpg'
     );
     
insert into comments(bno, mno, content, cre_dt) values('2', '1', '간격이 아슬아슬 해요..근데..간섭이 없다능 ㅎ', now());

insert into comments(bno, mno, content, cre_dt) values('2', '8', '아하..다른것 써도 되나보네요 ㅎ', now());

insert into comments(bno, mno, content, cre_dt) values('2', '2', 'ㄴ네 동호회에서 스알을 hg그랜저 와이퍼로 많이 교체해요', now());

insert into comments(bno, mno, content, cre_dt) values('2', '9', '간섭없으면 최대 면적으로 닦이는게 최고죠 ^^', now());

insert into comments(bno, mno, content, cre_dt) values('2', '10', 'ㅊㅊ', now());

insert into comments(bno, mno, content, cre_dt) values('2', '2', 'ㄴ감사합니다.^^', now());

insert into comments(bno, mno, content, cre_dt) values('2', '11', '저두스알인데 난주 바까바야겠네여 ㅋㅋ', now());

insert into comments(bno, mno, content, cre_dt) values('2', '2', 'ㄴ네', now());