package com.training.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.dao.RegisterDao;
import com.training.entity.Register;

import com.training.dao.RegisterDao;
import com.training.util.DbConnection;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private Connection con;

    public LoginServlet() {
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
		String typeOfUser=request.getParameter("typeOfUser");
		String userName=request.getParameter("userName");
		String passWord=request.getParameter("passWord");
		
		 RegisterDao details=new RegisterDao(con);

		
		Register reg=null;
        boolean status=false;
    try {
              reg = details.findById(userName);
                         
                                                 
                    } catch (SQLException e) {
                                    
                                    e.printStackTrace();
                    }
    
    if(reg.getPassWord().equals(passWord)&&reg.getTypeOfUser().equals(typeOfUser)) {
        status=true;
       
}

if(status) { 
RequestDispatcher dispatcher=request.getRequestDispatcher("travel.jsp");
HttpSession session=request.getSession(true);
session.setAttribute("user",reg);
dispatcher.forward(request, response);
}

else {
RequestDispatcher dispatcher=request.getRequestDispatcher("Login.jsp");
   request.setAttribute("err", "wrong user id and password");
   dispatcher.forward(request, response);
}

	}
	}

