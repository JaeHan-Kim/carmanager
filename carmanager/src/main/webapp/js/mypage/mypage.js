$(document).ready(function(){ 
  var useremail = sessionStorage.getItem('loginUseremail');
  $("#useremail").html(useremail);
	    
  var memberNo = sessionStorage.getItem('loginUser');
  $.post('ajax/detail.do', {
	no: memberNo
  }, function(resultObj) {
    var ajaxResult = resultObj.ajaxResult;
    if (ajaxResult.status == "success") {
	  var member = ajaxResult.data;
	    $("#nickname").val(member.nickName);
		$("#email").val(member.email);
		$("#password").val(member.password);
		var photopath = member.memberPhoto;
		$("#photo").attr("src", "../img/member/" + photopath);
	}
  }, 'json'); 	  
}); 

