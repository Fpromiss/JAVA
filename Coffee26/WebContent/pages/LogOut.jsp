<%@ page language="java" contentType="text/html;charset=utf-8"
	import="java.sql.*,Action.*"%>
<!DOCTYPE HTML>
<html>

<head>
<title>登出</title>
</head>

<body>

	<%
		Now n = new Now();
		n.delete();
	%>

	<script>
		window.document.location.href = "Home.jsp";
	</script>

</body>

</html>


