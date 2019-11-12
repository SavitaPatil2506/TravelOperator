package com.training.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.training.dao.TravelDao;
import com.training.entity.TravelDetails;
import com.training.util.DbConnection;

/**
 * Servlet implementation class TravelsAdd
 */
public class AddTravel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private Connection con;

    public AddTravel() {
        super();
        this.con=DbConnection.getOracleConnection();

        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strcode=request.getParameter("code");
		 long code=Long.parseLong(strcode);
		 
		 String sour=request.getParameter("source");
		 
		 String dest=request.getParameter("destination");
		
		 
		 String strstart=request.getParameter("startDate");
		 LocalDate startDate=LocalDate.parse(strstart);
		 
		 String strend=request.getParameter("endDate");
		 LocalDate endDate=LocalDate.parse(strend);
		 
		 String place1=request.getParameter("place1");
		 String place2=request.getParameter("place2");
		 String place3=request.getParameter("place3");

		 String strdays=request.getParameter("noOfDays");
		 long noOfDays=Long.parseLong(strdays);
		
		 String strnights=request.getParameter("noOfNights");
		 long noOfNights=Long.parseLong(strnights);
		
		 String strcost=request.getParameter("cost");
		 double cost=Long.parseLong(strcost);
		 
			TravelDetails travel=new TravelDetails(code,sour,dest,startDate,endDate,place1,place2,place3,noOfDays,noOfNights,cost);
			 TravelDao details=new TravelDao();

			 try {
				 int result;

				result = details.add(travel);
				
			} catch (SQLException e) {

				e.printStackTrace();
			}
					
			 
			 request.setAttribute("travelmsg", travel);
			 RequestDispatcher dispatcher=request.getRequestDispatcher("travel.jsp");
	dispatcher.forward(request, response);
			
		}

	
	}


