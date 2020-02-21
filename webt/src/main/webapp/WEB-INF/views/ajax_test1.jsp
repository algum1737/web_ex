<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax Test</title>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<!-- 이게 폼으로 정보 -->
<script type="text/javascript">
	$(function() {
		$('#btn2').click(function() {


			$.ajax({
				type : "POST",
				data : $("#frm").serialize(),
				url : "serialize",
				success : function(data) {
					alert(data);
					$('#result').text(data);
				},
				error : function() {
					alert("serialize err");
				}
			});
		});
	});
</script>

</head>

<body>
<form id=frm>
	name:<input type="text" name="name" id="name"><br>
	age:<input type="text" name="age" id="age">
</form>
	<button id="btn2">serialize</button>
	<div id="result"></div>
</body>

</html>