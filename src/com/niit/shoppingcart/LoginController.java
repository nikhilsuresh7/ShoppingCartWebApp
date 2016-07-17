package com.niit.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		System.out.println("doPost");
		
		
		
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		
		LoginDAO loginDAO = new LoginDAO();
		
		RequestDispatcher dispatcher;
		
		if( loginDAO.isValidUser ( userID, password) == true)
		{
			//Navigate to Home Page
			dispatcher = request.getRequestDispatcher("Home.html");
			dispatcher.forward(request, response);
		}
		else
		{
			// Navigate to Login Page itself with error message
			dispatcher = request.getRequestDispatcher("Login.html");			
			PrintWriter writer = response.getWriter();

		/*			try{
				writer.append("<h> Invalid Login Credentials... </h>");
			}
			catch(Exception e){}
		*/

			response.setContentType("text/html");
			writer.append("<h1> Invalid Login Credentials. Please Try Again. </h1>");

			dispatcher.include(request, response);
		}
	}

}
