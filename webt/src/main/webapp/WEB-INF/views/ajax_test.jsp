<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax Test</title>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
	$(function() {
		$('#AjaxStart').click(function() {
			var allData = "test1=1&test2=2";
			$.ajax({
				type : "POST",
				dataType : 'text',
			    //dataType: "json",
				data : allData,
				url : "ajax",
				beforeSend:function(){
					alert("시작!");
				},
				success : function(map) {
					alert("이거? = "+map.value);
				},
				error : function() {
					alert("난리네");
				}
			});
		});
	});
</script>
</head>
<body>
	<button id="AjaxStart">Ajax Start</button>
</body>
</html>