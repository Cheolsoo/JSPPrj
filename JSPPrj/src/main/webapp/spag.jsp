<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!--  --------------------------------------------------------- -->    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
pageContext.setAttribute("result", "hello");
%>
<body>
	<%=request.getAttribute("result") %>입니다.
	${requestScope.result}<br >
	${names[0]}<br >
	${names[1]}<br >
	${notice.title}<br >
	${result}<br>
	${param.n > 3}<br>
	${param.n ge 3}<br> <!--  가능하면 ge 와 같은 연산자를 사용 추천 -->
	${param.n/2}<br> <!--  n 값이 3 입력되면 결과는 1.5로 소숫점 출력됨 -->
	${empty param.n?'값이 비어 있습니다.':param.n}<br>
	${not empty param.n}<br>
	${header.accept}
</body>
</html>