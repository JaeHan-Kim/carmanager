var express = require('express');
var app = express();
var http = require('http');
var url = require('url'); 
var unirest = require('unirest');
var httpServer = http.createServer(function(request, response){

  response.setHeader("Content-Type", "text/json");
  response.setHeader("Access-Control-Allow-Origin", "*");
  
  var Request = unirest.get('http://api.openapi.io/opinetbasic//Oil/OilPriceAll.jsp?OutPut=Json');
    Request.header("x-waple-authorization", "Mzc0NC0xNDUzMTY3OTQzMjQwLTljMDZhN2JkLWQ0NjUtNDE2Yy04NmE3LWJkZDQ2NTQxNmM4Zg==")
    .end(function (result) {
      
      response.write(result.body);
      console.log(result.body);
    });
    return;
  
  response.end();
  
});

httpServer.listen(8989);

console.log("서버 실행 중...");