<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!--  --------------------------------------------------------- -->    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=request.getAttribute("result") %>입니다.
	${result}<br >
	${names[0]}<br >
	${names[1] }<br >
	${notice.title }<br >
</body>
</html>