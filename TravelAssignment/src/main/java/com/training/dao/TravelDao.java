package com.training.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.training.entity.TravelDetails;
import com.training.ifaces.Dao;
import com.training.ifaces.TourDao;
import com.training.util.DbConnection;

	public class TravelDao implements TourDao<TravelDetails> {
		 private Connection con;

		 List<TravelDetails>travelList;
		public TravelDao() {
			super();
			travelList=new ArrayList<>();
			this.con=DbConnection.getOracleConnection();
		}
		
		

		@Override
		public int add(TravelDetails t) throws SQLException {

	String sql="insert into savitatravel values(?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement pstmt=con.prepareStatement(sql);
			
			pstmt.setLong(1,t.getCode());
			pstmt.setString(2,t.getSource());
			pstmt.setString(3,t.getDestination());
			
			Date strDate=Date.valueOf(t.getStartDate());
			pstmt.setDate(4,strDate);
			
			Date endDate=Date.valueOf(t.getEndDate());
			pstmt.setDate(5,endDate);	
			pstmt.setString(6,t.getPlace1());
			pstmt.setString(7,t.getPlace2());
			pstmt.setString(8,t.getPlace3());

			pstmt.setLong(9,t.getNoOfDays());
			pstmt.setLong(10,t.getNoOfNights());
			pstmt.setDouble(11,t.getCost());

			 int rowAdded=pstmt.executeUpdate();
			return rowAdded;
		}

		

		@Override
		public List<TravelDetails> findAll() throws SQLException {
			String sql="select*from savitatravel";
			List<TravelDetails>travelList=new ArrayList<>();
			PreparedStatement pstmt=con.prepareStatement(sql);

			ResultSet resultSet=pstmt.executeQuery();
			
			while(resultSet.next()) {
				long code=resultSet.getLong("code");
				String dest=resultSet.getString("destination");
				String sour=resultSet.getString("source");

				LocalDate startDate=resultSet.getDate("startDate").toLocalDate();
				LocalDate endDate=resultSet.getDate("endDate").toLocalDate();
				String place1=resultSet.getString("place1");
				String place2=resultSet.getString("place2");
				String place3=resultSet.getString("place3");
				long noOfDays=resultSet.getLong("noOfDays");
				long noOfNights=resultSet.getLong("noOfNights");
				double cost=resultSet.getLong("cost");

				
			TravelDetails pmt=new TravelDetails(code,sour,dest,startDate,endDate,place1,place2,place3,noOfDays,noOfNights,cost);
			travelList.add(pmt);
		}

				return travelList;


		}

		@Override
		public TravelDetails findById(String source,String destination) throws SQLException {
			String sql="select * from savitatravel where source=? and destination=?";

			
			List<TravelDetails>travelList=new ArrayList<>();
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1,source);
			pstmt.setString(2,destination);

			ResultSet resultSet=pstmt.executeQuery();

			while(resultSet.next()) {
				long code=resultSet.getLong("code");
				String dest=resultSet.getString("destination");
				String sour=resultSet.getString("source");

				LocalDate startDate=resultSet.getDate("startDate").toLocalDate();
				LocalDate endDate=resultSet.getDate("endDate").toLocalDate();
				String place1=resultSet.getString("place1");
				String place2=resultSet.getString("place2");
				String place3=resultSet.getString("place3");
				long noOfDays=resultSet.getLong("noOfDays");
				long noOfNights=resultSet.getLong("noOfNights");
				double cost=resultSet.getLong("cost");

				TravelDetails pmt=new TravelDetails(code,sour,dest,startDate,endDate,place1,place2,place3,noOfDays,noOfNights,cost);
			return pmt;}
			return null;
	}

		@Override
		public int update(TravelDetails t) throws SQLException {
			
			return 0;
				}
			

		@Override
		public int remove(long code) throws SQLException {

			String sql="delete from savitatravel where code=?";
			List<TravelDetails>travelList=new ArrayList<>();
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setLong(1,code);
			int resultSet=pstmt.executeUpdate();
	return resultSet;
				
				

		}


		
		
	}

