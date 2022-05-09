<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>

<head>
	<title>SF Food Truck Finder</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<%-- <% 
	// get food trucks from request obj
	List<FoodTruck> sfFoodTrucks = (List<FoodTruck>) request.getAttribute("FOODTRUCK_LIST");
	
%> --%>
<body id=content-container>
	<div id = "header-container">
		<div id = "header">
			SF Food Truck Finder
		</div>
	</div>
	
	<div id = "data-container">
		<div id = "data-content">
			<form action="list-foodtrucks.jsp">
	    		Add new food truck: 
				<br/><br/>
				Name: <input type="text" name="name" />
				<br/><br/>
				Address: <input type="text" name="address" />
				<br/><br/>
				Food Type: <input type="text" name="foodType" />
				<br/><br/>
				 
				<input type="submit" value="Submit">
	    		
			</form>
			
			<%
		    // get items from the session
		    List<String> items = (List<String>) session.getAttribute("foodtrucks");
		
		    // if th items doesn't exist, then create a new one
		    if (items == null) {
		        items = new ArrayList<String>();
		        session.setAttribute("foodtrucks", items);
		    }
		    
		    // see if there is form data to add
		    String theName = request.getParameter("theName");
		    String theAddress = request.getParameter("theAddress");
		    String theFoodType = request.getParameter("theFoodType");
		    
		    // do not add duplicates or empty entries
			boolean isItemNotEmpty = theName != null && theName.trim().length() > 0;
			boolean isItemNotDuplicate = theName != null && !items.contains(theName.trim());
			
			if (isItemNotEmpty && isItemNotDuplicate) {    		
				items.add(theName.trim());    		
			}
		%>
		
		<hr>
		<b>Food Trucks:</b> <br/>
		
			 <table>
				<tr>
					<th>Name</th>
					<th>Address</th>
					<th>Food Type</th>
				</tr>
				<tr>
				
				<%
				    for (String input : items) {
				        out.println("<th>" + input + "</th>");
				    }
				%></tr>
				
				<%-- // once db is setup, get data from table
				
				<% for (FoodTruck sfFoodTruck : sfFoodTrucks) { %>
				
				<tr>
					<td><%= sfFoodTruck.getName() %></td>
					<td>sfFoodTruck.getAdress()</td>
					<td>sfFoodTruck.getEmail()</td>
				</tr>
				
				<% } %> --%>
			</table>
		</div>
	</div>
<%-- <%= sfFoodTrucks %> --%>

</body>
</html>