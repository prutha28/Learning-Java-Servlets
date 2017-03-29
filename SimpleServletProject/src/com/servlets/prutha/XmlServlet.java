package com.servlets.prutha;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet( urlPatterns = {"/xmlservlet", "/anotherservlet"})
public class XmlServlet extends HttpServlet {

	private static final long serialVersionUID = 2342090221175341334L;

	@Override
	protected void doGet( HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		
		response.setContentType("text/html");
		String username = request.getParameter("username");
		response.getWriter().append("Hello ").append(username);
	}
	
	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response) throws IOException{
		String username = request.getParameter("username");
		response.getWriter().append("Hello ").append(username);
	}

}
