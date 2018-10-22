package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Student;
import com.servicei.Servicei;
import com.serviceimpl.Serviceimpl;
@WebServlet("/log2")
public class RegisterServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Student s=new Student();
		
		s.setName(request.getParameter("t1"));
		s.setMobileno(request.getParameter("t2"));
		s.setAddress(request.getParameter("t3"));
		s.setUsername(request.getParameter("t4"));
		s.setPassword(request.getParameter("t5"));
		
		Servicei ser=new Serviceimpl();
		
		ser.register(s);
		request.setAttribute("msg","Register Successfully");
		request.getRequestDispatcher("index1.jsp").forward(request, response);
		
		
	}

}
