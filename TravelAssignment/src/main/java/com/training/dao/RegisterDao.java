package com.training.dao;
import com.training.entity.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import com.training.ifaces.Dao;
import com.training.util.DbConnection;

public class RegisterDao implements Dao<Register> {
	 private Connection con;

	 List<Register>regList;
	public RegisterDao(Connection con) {
		super();
		regList=new ArrayList<>();
		this.con=con;
	}
	
	

	@Override
	public int add(Register t) throws SQLException {

String sql="insert into savitaregister values(?,?,?,?,?,?)";
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		pstmt.setString(1,t.getFirstName());
		pstmt.setString(2,t.getLastName());
		pstmt.setString(3,t.getTypeOfUser());
		pstmt.setString(4,t.getUserName());
		pstmt.setString(5,t.getPassWord());
		pstmt.setLong(6,t.getPhoneNumber());
		
		 int rowAdded=pstmt.executeUpdate();
		return rowAdded;
	}

	

	@Override
	public List<Register> findAll() throws SQLException {
		String sql="select*from savitaregister";
		List<Register>regList=new ArrayList<>();
		PreparedStatement pstmt=con.prepareStatement(sql);

		ResultSet resultSet=pstmt.executeQuery();
		
		while(resultSet.next()) {
			String firstName=resultSet.getString("firstName");
			String lastName=resultSet.getString("lastName");
			String typeOfUser=resultSet.getString("typeOfUser");
			String userName=resultSet.getString("userName");
			String passWord=resultSet.getString("passWord");
		long phoneNumber=resultSet.getLong("phoneNumber");
		
		Register pmt=new Register(firstName,lastName,typeOfUser,userName,passWord,phoneNumber);
		regList.add(pmt);
	}

			return regList;


	}

	@Override
	public Register findById(String id) throws SQLException {
		String sql="select * from savitaregister where userName=?";

		
		List<Register>pmtList=new ArrayList<>();
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,id);
		ResultSet resultSet=pstmt.executeQuery();

		while(resultSet.next()) {
			String firstName=resultSet.getString("firstName");
			String lastName=resultSet.getString("lastName");
			String typeOfUser=resultSet.getString("typeOfUser");
			String userName=resultSet.getString("userName");
			String passWord=resultSet.getString("passWord");
		long phoneNumber=resultSet.getLong("phoneNumber");
		
		Register pmt=new Register(firstName,lastName,typeOfUser,userName,passWord,phoneNumber);
		return pmt;}
		return null;
}

	@Override
	public int update(Register t) throws SQLException {
		String sql="update savitaregister set lastName=?, typeOfUser=? , userName=? , passWord=?,phoneNumber,where firstName=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
pstmt.setString(1,t.getLastName());
pstmt.setString(2,t.getTypeOfUser());
pstmt.setString(3,t.getUserName());
pstmt.setString(4,t.getPassWord());
pstmt.setLong(5,t.getPhoneNumber());
pstmt.setString(6,t.getFirstName());

int rowUpdated=pstmt.executeUpdate();
return rowUpdated;
}
		

	@Override
	public int remove(long id) throws SQLException {

		String sql="delete from savitaregister where id=?";
		List<Register>pmtList=new ArrayList<>();
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setLong(1,id);
		int resultSet=pstmt.executeUpdate();
return resultSet;
			
			

	}


	
	
}
