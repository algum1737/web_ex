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
<!-- <script type="text/javascript">
	$(function() {
		$('#btn1').click(function() {
						var form = {
							name : "jamong",
							age : 23
						}
			//var allData = "test1=1&test2=2";

			$.ajax({
				type : "POST",
				data : form,
				url : "requestObject",
				success : function(data) {
					alert(data);
					$('#result').text(data);
				},
				error : function() {
					alert("simpleWithObject err");
				}
			});
		});
	});
</script> -->
<!-- 일반 text -->
<script type="text/javascript">
	$(function() {
		$('#btn1').click(function() {

			var allData = "test1=1&test2=2";

			$.ajax({
				type : "POST",
				dataType : 'text',
				data : allData,
				url : "requestObject",
				success : function(data) {
					alert(data);
					$('#result').text(data);
				},
				error : function() {
					alert("simpleWithObject err");
				}
			});
		});
	});
</script>
</head>

<body>
	<button id="btn1">simpleAJAX</button>
	<div id="result"></div>
</body>

</html>