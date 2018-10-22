package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Student;
import com.servicei.Servicei;
import com.serviceimpl.Serviceimpl;

@WebServlet("/log1")
public class Login  extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	Student s=new Student();	
		
	s.setUsername(request.getParameter("t1"));
		s.setPassword(request.getParameter("t2"));
		
	Servicei ser=new Serviceimpl();
	List<Student> list=ser.login(s);
	
		request.setAttribute("data", list);
		request.getRequestDispatcher("success.jsp").forward(request, response);
		
	}

}
