package com.training.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.training.dao.RegisterDao;
import com.training.entity.Register;
import com.training.util.DbConnection;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private Connection con;

    public RegisterServlet() {
        super();
        con=DbConnection.getOracleConnection();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String typeOfUser=request.getParameter("typeOfUser");
		String userName=request.getParameter("userName");
		String passWord=request.getParameter("passWord");
		
        String phoneNumber=request.getParameter("phNo");
		 long phNo=Long.parseLong(phoneNumber);
		
		 
		 
		 Register register=new Register(firstName,lastName,typeOfUser,userName,passWord,phNo);
		 RegisterDao details=new RegisterDao(con);
	
		 
		 

		try {
			 int result;

			result = details.add(register);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
				
		 
		 request.setAttribute("Msg", register);
		 RequestDispatcher dispatcher=request.getRequestDispatcher("Login.html");
dispatcher.forward(request, response);
		
 }

}
