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

@WebServlet("/edited")
public class EditServlet extends HttpServlet
{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student s=new Student();
		s.setId(Integer.parseInt(request.getParameter("id")));
			
		Servicei ser=new Serviceimpl();
	Student list=ser.edit(s);
		
		request.setAttribute("key", list);
		request.getRequestDispatcher("update.jsp").forward(request, response);
		
	}
}
