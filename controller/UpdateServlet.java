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

@WebServlet("/up")
public class UpdateServlet  extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student s=new Student();
		s.setId(Integer.parseInt(request.getParameter("id")));
		s.setName(request.getParameter("name"));
		s.setMobileno(request.getParameter("mobileno"));
		s.setAddress(request.getParameter("address"));
		s.setUsername(request.getParameter("username"));
		s.setPassword(request.getParameter("password"));
		
		Servicei ser=new Serviceimpl();
		List<Student> list=ser.update(s);
		request.setAttribute("data", list);
		request.getRequestDispatcher("success.jsp").forward(request, response);
	}

}
