package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 2022.10.02 02:36
// 어플리케이션 저장소
// 세션, 쿠키 등등

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		ServletContext application = request.getServletContext();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String v_ = request.getParameter("v");		
		String op = request.getParameter("operator");
		
		int v = 0;
		
		if (!v_.equals("")) v = Integer.parseInt(v_);		
		
		// 계산
		if(op.equals("=")) {
			
			// 앞에서 저장된 값
			int x = (Integer)application.getAttribute("value"); 
					
			// 사용자가 지금 전달한 값
			int y = v;
			
			String operator = (String)application.getAttribute("op");
			
			int result = 0;
			
			if(operator.equals("+"))
				result=x+y;
			else
				result=x-y;			

			response.getWriter().printf("result is %d\n", result);
		}
		// 값을 저장
		else {
			application.setAttribute("value", v);
			application.setAttribute("op", op);
		}
		
	}

}
