<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.training.entity.Register,
    com.training.dao.TravelDao,
    com.training.entity.TravelDetails,
    java.util.*"%>
   
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Travel Details</title>
 

</head>
<body>

<%
Register user=(Register)session.getAttribute("user");

if(user.getTypeOfUser().equalsIgnoreCase("employee")){     
%>

<h3 align="center">Add TravelDetails</h3>

<form action="AddTravel" method="post">
<table align="center">
<tr>
<th>
<label>Tour Code</label>
</th>
<th>
<input type="text" name="code">
</th>
</tr>
<tr>
<th>
<label>Source</label>
</th>
<th>
<select name="source">
<option value="Bengaluru">Bengaluru</option>
<option value="Mangalore">Mangalore</option>
<option  value="Thirupati">Thirupati</option>
<option value=" Delhi">Delhi</option>
<option  value="Hydrabad">Hydrabad</option>

</select> 
</th>
</tr>
<tr>
<th><label>Destination</label>
</th>
<th>
<select name="destination">
<option value="Bengaluru">Bengaluru</option>
<option value="Mangalore">Mangalore</option>
<option  value="Thirupati">Thirupati</option>
<option value=" Delhi">Delhi</option>
<option  value="Hydrabad">Hydrabad</option>

</select>
</th>
</tr>
<tr>
<th>
<label>Start Date</label>
</th>
<th>
<input type="date" name="startDate">
</th>
</tr>
<tr>
<th>
<label>End Date</label>
</th>
<th>
<input type="date" name="endDate">
</th>
</tr>
<tr>
<th>
<label>First Stop</label>
</th>
<th>
<input type="text" name="place1">
</th>
</tr>
<tr>
<th>
<label>Second Stop</label>
</th>
<th>
<input type="text" name="place2">
</th>
</tr>
<tr>
<th>
<label>Third Stop</label>
</th>
<th>
<input type="text" name="place3">
</th>
</tr>
<tr>
<th>
<label>Number of Days</label>
</th>
<th>
<input type="text" name="noOfDays">
</th>
</tr>
<tr>
<th>
<label>Number of Nights</label>
  </th>
  <th>
<input type="text" name="noOfNights">
</th>
</tr>

<tr>
<th>
<label>Cost of the Trip</label></th>
<th>
<input type="text" name="cost">
</th>
</tr>
<tr><th></th><th><input type="submit" name="add" value="ADD DETAILS"/></th>
</tr>
</table>


</form>

<% 
} %>
<br>
<h3 align="center">TRAVEL DETAILS</h3>
<br>
<%

TravelDao details=new TravelDao();
List<TravelDetails>travelList=new ArrayList<>();
travelList=details.findAll();
request.setAttribute("msg", travelList);
%>

<table border="1" cellpadding="5" cellspacing="0" >
<tr><th>CODE</th>
<th>SOURCE</th>
<th>DESTINATION</th>
<th>START DATE</th>
<th>END DATE</th>
<th>FIRST STOP</th>
<th>SECOND STOP</th>
<th>THIRD STOP</th>
<th>NO OF DAYS</th>
<th>NO OF NIGHTS</th>
<th>COST</th>
</tr>

<c:forEach var="eachTravel" items="${requestScope.msg}">

<tr><td><h2><c:out value="${eachTravel.code}"/></h2></td>
<td><h2><c:out value="${eachTravel.source}"/></h2></td>
<td><h2><c:out value="${eachTravel.destination}"/></h2></td>
<td><h2><c:out value="${eachTravel.startDate}"/></h2></td>
<td><h2><c:out value="${eachTravel.endDate}"/></h2></td>
<td><h2><c:out value="${eachTravel.place1}"/></h2></td>
<td><h2><c:out value="${eachTravel.place2}"/></h2></td>
<td><h2><c:out value="${eachTravel.place3}"/></h2></td>
<td><h2><c:out value="${eachTravel.noOfDays}"/></h2></td>
<td><h2><c:out value="${eachTravel.noOfNights}"/></h2></td>
<td><h2><c:out value="${eachTravel.cost}"/></h2></td>
</tr></c:forEach>

</table>

</body>

</html>
