<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String cnt_ = request.getParameter("cnt");
int cnt = 100;
if ( cnt_ != null && !cnt_.equals(""))
	cnt = Integer.parseInt(cnt_);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp 파일명은 url로 연결되기 때문에 소문자 추천</title>
</head>
<body>
<% for(int i=0; i<cnt; i++) { %>
	안녕 Servlet!!<br>
<%} %>
</body>
</html>