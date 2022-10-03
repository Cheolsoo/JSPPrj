// 2022.10.03 16:39
// 쿠키 maxAge 설정
//
// 2022.10.03 16:28
// 30 - cookie path 예제, 현재 버전은 버그가 있음

package com.newlecture.web;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
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

@WebServlet("/calc3")
public class Calc3 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// 쿠키 읽기
		Cookie[] cookies = request.getCookies();
		
		String value = request.getParameter("value");		
		String operator = request.getParameter("operator");
		String dot = request.getParameter("dot");
		
		String exp = "";
		
		// 쿠키에서 읽어오기
		if (cookies != null) {
			for(Cookie c : cookies) {
				if (c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
			}
		}
		
		// 입력된 문자열이 = 표시인 경우 쿠키에 저장된 연산 실행
		if (operator != null && operator.equals("=")) {
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 입력된 문자열이 = 문자가 아닌 경우 쿠키에 계속 저장
		else {
			exp += (value == null)?"":value;
			exp += (operator == null)?"":operator;
			exp += (dot == null)?"":dot;
		}
		Cookie expCookie = new Cookie("exp", exp);
		
		response.addCookie(expCookie);
		response.sendRedirect("calcpage");
		
	}

}
