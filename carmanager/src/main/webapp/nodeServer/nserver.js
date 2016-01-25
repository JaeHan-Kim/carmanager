var http = require('http');
var mysql = require('mysql');
var url = require('url'); 
var unirest = require('unirest');
var querystring = require('querystring');

var pool  = mysql.createPool({
  connectionLimit : 10,
  host     : 'localhost',
  user     : 'java76',
  password : '1111',
  database : 'carmanager'
});

var resultR =
{
  "channel": 
  {
    "status": "success"
  }
};
var handlerMap = {};

handlerMap['/oil'] = function(requset, response) {
  console.log("주유 단가 ! ");
  response.setHeader("Content-Type", "text/json");
  response.setHeader("Access-Control-Allow-Origin", "*");
  var Request = unirest.get('http://api.openapi.io/opinetbasic//Oil/OilPriceAll.jsp?OutPut=Json');
  Request.header("x-waple-authorization", "Mzc0NC0xNDUzMTY3OTQzMjQwLTljMDZhN2JkLWQ0NjUtNDE2Yy04NmE3LWJkZDQ2NTQxNmM4Zg==")
  .end(function (result) {
    
    response.end(result.body);
    console.log(result.body);
  });
  return;

  response.end();
};

handlerMap['/checkEmail'] = function(request, response) {
  var urlInfo = url.parse(request.url, true);
  var emailPattern = /\w+@\w+\.\w+/;
  
  console.log("이메일 중복 체크 확인 중 ! ");
  console.log(urlInfo.query.email);
  console.log(emailPattern.test(urlInfo.query.email));
  response.setHeader("Content-Type", "text/json");
  response.setHeader("Access-Control-Allow-Origin", "*");
  if (emailPattern.test(urlInfo.query.email)) {
    pool.query(
        'select count(mno) as count from members where email=?',
        [urlInfo.query.email], 
        function(err, rows, fields) { 
          if (err) throw err;
          console.log(rows[0].count);
          if (rows[0].count != 0) {
            resultR.channel.status = "failure";
          } else {
            resultR.channel.status = "success";
          }
          response.write(JSON.stringify(resultR));
          response.end();
      });
  } else {
    resultR.channel.status = "notEmail";
    response.write(JSON.stringify(resultR));
    response.end();
  }
};

handlerMap['/checkNickname'] = function(request, response) {
  var urlInfo = url.parse(request.url, true);
  console.log("닉네임 중복 체크!");
  console.log(urlInfo.query.nickname);
  console.log(urlInfo.query.nickname.length);
  response.setHeader("Content-Type", "text/json");
  response.setHeader("Access-Control-Allow-Origin", "*");
  if(urlInfo.query.nickname.length > 0 && urlInfo.query.nickname.length <= 10) {
    pool.query(
        'select count(mno) as count from members where nick=?',
        [urlInfo.query.nickname], 
        function(err, rows, fields) { 
          if (err) throw err;
          console.log(rows[0].count);
          if (rows[0].count != 0) {
            resultR.channel.status = "failure";
          } else {
            resultR.channel.status = "success";
          }
          response.write(JSON.stringify(resultR));
          response.end();
      });    
  } else {
    resultR.channel.status = "notNickname";
    response.write(JSON.stringify(resultR));
    response.end();
  }
};
var httpServer = http.createServer(function(request, response){
  var urlInfo = url.parse(request.url);
  
  var handler = handlerMap[urlInfo.pathname];
  
  if(handler) {
    handler(request, response);
  } else {
    console.log("없네...");
    response.end();
  }
});

httpServer.listen(8989);
console.log("서버 실행 중...");