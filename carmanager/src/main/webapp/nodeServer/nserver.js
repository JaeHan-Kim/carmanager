var http = require('http');
var url = require('url'); 
var unirest = require('unirest');
var querystring = require('querystring');
var mysql = require('mysql');

var httpServer = http.createServer(function(request, response){
  
  response.setHeader("Content-Type", "text/json");
  response.setHeader("Access-Control-Allow-Origin", "*");
  
  var connection = mysql.createConnection({
    host     : 'localhost',
    user     : 'java76',
    password : '1111',
    database : 'carmanager'
  });
  
  var resultT =
  {
    "channel": 
    {
      "status": "success"
    }
  };
  
  var resultF =
  {"channel":{"status": "notEmail"}};  
  var urlInfo = url.parse(request.url);
 
  if (request.url == '/favicon.ico') {
    response.end();
    return;
  }
 
  if (request.url == '/oil') {
    console.log("주유 단가 ! ");
    var Request = unirest.get('http://api.openapi.io/opinetbasic//Oil/OilPriceAll.jsp?OutPut=Json');
    Request.header("x-waple-authorization", "Mzc0NC0xNDUzMTY3OTQzMjQwLTljMDZhN2JkLWQ0NjUtNDE2Yy04NmE3LWJkZDQ2NTQxNmM4Zg==")
    .end(function (result) {
      
      response.end(result.body);
      console.log(result.body);
    });
    return;
  
    response.end();
  }
  
  if (urlInfo.pathname == '/checkEmail') {
    console.log("이메일 중복 체크 확인 중 ! ");
  }

  response.end();
  return;
  
});

httpServer.listen(8989);

console.log("서버 실행 중...");