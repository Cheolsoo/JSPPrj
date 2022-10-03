// 2022.10.03 16:39
// 쿠키 maxAge 설정
//
// 2022.10.03 16:28
// 30 - cookie path 예제, 현재 버전은 버그가 있음

package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 2022.10.02 02:36
// 어플리케이션 저장소
// 세션, 쿠키 등등

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		
		// 쿠키 읽기
		Cookie[] cookies = request.getCookies();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String v_ = request.getParameter("v");		
		String op = request.getParameter("operator");
		
		int v = 0;
		
		if (!v_.equals("")) v = Integer.parseInt(v_);		
		
		// 계산
		if(op.equals("=")) {
			
			// 앞에서 저장된 값
			//int x = (Integer)application.getAttribute("value"); 
			
			// 세션에서 구하기
			//int x = (Integer)session.getAttribute("value");
			
			// 이제는 쿠키에서 구하기
			int x = 0;
			
			for(Cookie c : cookies) {
				if (c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			}
					
			// 사용자가 지금 전달한 값
			int y = v;
			
			//String operator = (String)application.getAttribute("op");
			
			// 세션 이용해서 연산자 구하기
			//String operator = (String)session.getAttribute("op");
			
			// 쿠키 이용해서 연산자 구하기
			String operator = "";
			for(Cookie c : cookies) {
				if (c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			}
			
			
			int result = 0;
			
			if(operator.equals("+"))
				result=x+y;
			else
				result=x-y;			

			response.getWriter().printf("result is %d\n", result);
		}
		// 값을 저장
		else {
			//application.setAttribute("value", v);
			//application.setAttribute("op", op);

			//세션 사용 예제 '22.10.03
			//session.setAttribute("value", v);
			//session.setAttribute("op", op);
			
			// 쿠키 사용 예제 '22.10.03 14:44
			// 쿠키값으로 사용할 수 있는 값은 URL 인코딩된 문자열만 사용 가능
			// 그래서 문자열변환 사용함 : String.valueOf("문자열");
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", op);
			
			// 쿠키에 url path 지정하기
			valueCookie.setPath("/calc2");
			
			// 24시간동안 쿠키 유지
			valueCookie.setMaxAge(24*60*60);
			
			opCookie.setPath("/calc2");
			
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
		}
		
	}

}
