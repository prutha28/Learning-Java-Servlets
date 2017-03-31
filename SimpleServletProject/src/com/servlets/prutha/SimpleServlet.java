package com.servlets.prutha;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(
		description = "This is a simple servlet class", 
		urlPatterns = { "/SimpleServlet" }, 
		initParams = { @WebInitParam( name ="applicationName", value = "My First Servlet Application")}
		)
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

		// Using Http Context object.
		// Anything set in the HTTP Context is globally available across all 
		// servlets in the application for all the users in any browser session/ machine
		
		ServletContext context = request.getServletContext();
		context.setAttribute("postingDate", "30-March-2017");
		String postingDateFromContext = (String) context.getAttribute("postingDate"); 
		response.getWriter().append("\nPosting Date obtained from the context is ").append(postingDateFromContext);
			
		HttpSession session = request.getSession() ;
		String username = request.getParameter("username");
		
		// If no username was explicitly specified in the request
		// use the username from the session		
	
		if( username == null || username.length() == 0){
			username = (String)session.getAttribute("username");
			response.getWriter().append("\nUser Name obtained from the session is ").append(username);
		}else{			
			response.getWriter().append("\nUser Name obtained from the request is ").append(username);
		}

		session.setAttribute("username", username);
		
		// Using the init parameters
		String applicationName = this.getServletConfig().getInitParameter("applicationName");
		response.getWriter().append("\nApplication Name  obtained from the servlet config is ").append(applicationName);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
