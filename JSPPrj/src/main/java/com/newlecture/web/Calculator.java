package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class Calculator extends HttpServlet {
	/*
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if(req.getMethod().equals("GET")) {
			System.out.println("GET 요청이 왔습니다.");
		}
		else if(req.getMethod().equals("POST")) {
			System.out.println("POST 요청이 왔습니다.");
		}
		
		super.service(req, resp);
	}
	*/
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		
		String exp = "0";
		
		if (cookies != null) {
			for(Cookie c : cookies) {
				if (c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
			}
		}
		
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("<style>");
		out.write("input {");
		out.write("width:50px;");
		out.write("height:50px;");
		out.write("}");
		out.write(".output {");
		out.write("width:50px;");
		out.write("background: #e9e9e9;");
		out.write("font-size:24px;");
		out.write("font-weight: bold;");
		out.write("text-align: right;");
		out.write("padding: 0px 5px;");
		out.write("}");
		out.write("</style>");
		out.write("</head>");
		out.write("<body>");
		out.write("<div>");
		
		// 자기 자신에게 post 하는 경우 action 부분 생략 가능
		//out.write("<form action=\"calc3\" method=\"post\">");
		out.write("<form method=\"post\">");
		
		out.write("					<div>");
		out.write("					<table>");
		out.write("<tr>");
		out.printf("<td class=\"output\" colspan=\"4\">%s</td>", exp);
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"CE\" /></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"C\" /></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"BS\" /></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"/\" /></td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"7\" /></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"8\" /></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"9\" /></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"*\" /></td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"4\" /></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"5\" /></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"6\" /></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"-\" /></td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"1\" /></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"2\" /></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"3\" /></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"+\" /></td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td></td>");
		out.write("<td><input type=\"submit\" name=\"value\" value=\"0\" /></td>");
		out.write("<td><input type=\"submit\" name=\"dot\" value=\".\" /></td>");
		out.write("<td><input type=\"submit\" name=\"operator\" value=\"=\" /></td>");
		out.write("</tr>");
		out.write("</table>");			
		out.write("</form>");
		out.write("</div>");
		out.write("</body>");
		out.write("</html>");		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
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
		// 입력된 문자열이 C 경우, 쿠키 삭제 
		// (삭제라기보다는 공백 문자를 쿠키에 저장하는 것으로 이해됨)
		else if (operator != null && operator.equals("C")) {
			exp = "";
			
		}
		// 입력된 문자열이 = 문자가 아닌 경우 쿠키에 계속 저장
		else {
			exp += (value == null)?"":value;
			exp += (operator == null)?"":operator;
			exp += (dot == null)?"":dot;
		}
		
		Cookie expCookie = new Cookie("exp", exp);
		
		// 입력된 값이 문자 C 인 경우에만 쿠키 해제
		if (operator != null && operator.equals("C")) {
			expCookie.setMaxAge(0);
		}
		
		// 다중 경로는 안됨, 안타깝지만 path는 하나만 등록 가능
		// 아래처럼 경로 설정하면 다른 url에는 쿠키가 전달 안됩니다. 
		expCookie.setPath("/calculator");
		response.addCookie(expCookie);
		
		// sendRedirect 요청은 GET 요청을 의미합니다. 
		response.sendRedirect("calculator");
	}
}
