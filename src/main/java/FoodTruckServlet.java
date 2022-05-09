import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import javax.sql.DataSource;
import java.util.*;

/**
 * Servlet implementation class FoodTruckServlet
 */
public class FoodTruckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FoodTruckDBUtil foodTruckDBUtil;
	
	@Resource(name="jdbc/sf-foodtruck-list")
	private DataSource datasource;

	private org.apache.tomcat.jdbc.pool.DataSource dataSource;
	
	// custom initialization
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		// create instance of foodtruckDBUtil
		try {
			foodTruckDBUtil = new FoodTruckDBUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// list in MVC pattern
		try {
			listFoodTrucks(request, response);
		} catch (Exception exc) {
			throw new ServletException(exc);
		}
	}


	private void listFoodTrucks(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get food trucks from the db util
		List<FoodTruck> foodtrucks = foodTruckDBUtil.getFoodTrucks();
		
		// send to jsp page (view), handle in one central location
		request.setAttribute("FOODTRUCK_LIST", foodtrucks);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-foodtrucks.jsp");
		dispatcher.forward(request, response);
		
	}

}
