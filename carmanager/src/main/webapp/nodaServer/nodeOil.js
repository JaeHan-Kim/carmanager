// 유가 정보 불러오기 위한 라이브러리 설치 경로 
// -> 각자의 camanager 프로젝트 밑에 설치
// 설치 : npm install unirest 
// node.js 실행 위한 js 파일 주소 경로
// cd 자신의 주소를 입력/git/carmanager/carmanager/src/main/webapp/nodeServer
// url : http://localhost:8989/oil

var http = require('http');
var url = require('url'); 
var unirest = require('unirest');
var httpServer = http.createServer(function(request, response){

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
  
});

httpServer.listen(8989);

console.log("서버 실행 중...");