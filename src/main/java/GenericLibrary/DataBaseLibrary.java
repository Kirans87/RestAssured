package GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseLibrary {
	
	Connection con;
	
	public void connectToDatabase() throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	}
	
	public String getDataFromDataBase(String query, int columnIndex) throws SQLException {
		
		ResultSet result = con.createStatement().executeQuery(query);
		String value = result.getString(columnIndex);
		return value;
	}
	
	public void closeConnecton() throws SQLException {
		con.close();
	}

}
