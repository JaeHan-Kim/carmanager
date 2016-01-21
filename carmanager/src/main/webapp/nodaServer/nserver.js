var http = require('http');
var url = require('url'); 
var unirest = require('unirest');
var httpServer = http.createServer(function(request, response){
  response.setHeader("Content-Type", "text/json");
  response.setHeader("Access-Control-Allow-Origin", "*");
  response.write(response.statusCode.toString());
  console.log("adsasd")
  var accountStr ={
      "channel": {
        "docid": "L1891414883",
        "title": "Search detail Daum Open API",
        "desc": "Daum Open API search result",
        "totalCount": 1,
      }
    };
  
  console.log(accountStr);
  response.end(accountStr);
  return;
  
  
});

httpServer.listen(8989);

console.log("서버 실행 중...");