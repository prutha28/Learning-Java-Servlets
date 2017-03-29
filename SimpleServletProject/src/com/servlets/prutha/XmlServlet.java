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
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String designation = request.getParameter("designation");
		String currentCity = request.getParameter("currentCity");
		String[] citiesStayed = request.getParameterValues("citiesStayed");
		
		response.getWriter().append("Hello ").append(username);
		response.getWriter().append("Here are the other details: \n");
		response.getWriter().append("\n ").append(firstname);
		response.getWriter().append("\n ").append(lastname);
		response.getWriter().append("\n ").append(designation);
		response.getWriter().append("\n ");
		response.getWriter().append("Current City:").append(currentCity);
		response.getWriter().append("\n ");
		response.getWriter().append("Cities where you stayed:").append("\n");
		
		for( String city : citiesStayed){
			response.getWriter().append(city + ", ");
		}

	}

}
