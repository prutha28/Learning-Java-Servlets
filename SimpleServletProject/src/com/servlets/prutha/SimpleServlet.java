package com.servlets.prutha;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(description = "This is a simple servlet class", urlPatterns = { "/SimpleServlet" })
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		System.out.println("Request : " + request);
//		System.out.println("Response : " + response);

		HttpSession session = request.getSession() ;
		String username = request.getParameter("username");
		
		// If no username was explicitly specified in the request
		// use the username from the session		
		if( username == null || username.length() == 0){
			username = (String)session.getAttribute("username");
		}

		session.setAttribute("username", username);
		response.getWriter().append("Hello ").append(username);
		//		response.getWriter().append("\n").append(request.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
