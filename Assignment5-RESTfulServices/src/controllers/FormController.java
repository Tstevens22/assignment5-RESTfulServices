package controllers;
import java.sql.*;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import business.OrdersBusinessInterface;

@ManagedBean
public class FormController {

	@Inject
	OrdersBusinessInterface services;

	public String onLogoff() {
		// Invalidate the Session to clear the security token
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		System.out.println("You clikced the log out button");

		// Redirect to a protected page (so we get a full HTTP Request) to get Login
		// Page
		return "ResponsePage.xhtml?faces-redirect=true";
	}

	public OrdersBusinessInterface getService() {
		return services;
	}

	public void getAllOrders() throws SQLException {

		// connect to the database
		String dbURL = "jdbc:mysql://localhost:3306/testDB";
		String user = "root";
		String password = "root";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(dbURL, user, password);
			System.out.println("===== Successful!! =====");

			// create a SQL statement
			stmt = conn.createStatement();
			// execute the statement
			rs = stmt.executeQuery("select * from testDB.Orders");
			// process the rows in the result set
			while (rs.next()) {
				System.out.println("Id = " + rs.getInt("ID") + " Order Number = " + rs.getString("ORDER_NO")
						+ " Product Name = " + rs.getString("PRODUCT_NAME") + " Price = " + rs.getFloat("PRICE")
						+ " Quantity = " + rs.getInt("QUANTITY"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("===== Failure!! =====");
			e.printStackTrace();
		} finally {
			// close the connection to the DB
			rs.close();
			stmt.close();
			conn.close();
		}

		return;
	}

	public void insertOrder() throws SQLException {

		// connect to the database
		String dbURL = "jdbc:mysql://localhost:3306/testDB";
		String user = "root";
		String password = "root";

		Connection conn = null;
		Statement stmt = null;
		int rowsAffected = 0;
		try {
			conn = DriverManager.getConnection(dbURL, user, password);

			// create a SQL statement
			stmt = conn.createStatement();
			// execute the statement
			rowsAffected = stmt.executeUpdate(
					"insert into testDB.Orders(ID, ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) values (null, '010', 'This is a new Insertion', '25.00', '100' )");
			// prints the number of rows that have been updated
			System.out.println("The number of rows affected : " + rowsAffected);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("===== Failure!! =====");
			e.printStackTrace();
		} finally {
			// close the connection to the DB
			stmt.close();
			conn.close();
		}

		return;
	}

}
