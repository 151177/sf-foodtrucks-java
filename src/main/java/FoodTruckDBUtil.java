import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.tomcat.jdbc.pool.DataSource;

public class FoodTruckDBUtil {
	
	// reference to data source
	private DataSource dataSource;
	
	public FoodTruckDBUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<FoodTruck> getFoodTrucks() throws Exception {
		List<FoodTruck> foodtrucks = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// connection
			myConn = dataSource.getConnection();
		
			// create sql stmt
			String sql = "select * from foodtruck order by name";
			
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				// get id
				int id = myRs.getInt("id");
				String name = myRs.getString("name");
				String address = myRs.getString("address");
				String foodType = myRs.getString("food_type");
				
				// create new food truck object
				FoodTruck tempFoodTruck = new FoodTruck(id, name, address, foodType);
				foodtrucks.add(tempFoodTruck);
				
			}
			
			return foodtrucks;
		}
		finally {
			// close jdbc objects
			close(myConn, myStmt, myRs);
		}
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		
		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
