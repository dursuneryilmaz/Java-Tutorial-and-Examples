package crud;

/*
 * jdbc crud operations using mysql database
 * mysql's (or used database system) driver must be added to library
 * this examples uses mysql's pre-created "world" database
 * 
 * */

import java.sql.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws SQLException {
		insertData(); // Create new record/data
		selectData(); // Read record/data
		updateData(); // Update record/data
		deleteData(); // Delete record/data
	}

	public static void insertData() throws SQLException {
		// create a connection
		Connection connection = null;
		// get an instance of dbhelper to get connection
		DbHelper helper = new DbHelper();
		// create a statement to create a database query
		PreparedStatement statement = null;
		try {
			// assign the connection
			connection = helper.getConnection();
			// write the sql query and fill the parameters
			String sql = "insert into city (Name,CountryCode,District,Population) values(?,?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, "Düzce");
			statement.setString(2, "TUR");
			statement.setString(3, "Turkey");
			statement.setInt(4, 70000);
			// insert operation returns 1 for successful insert or 0 for error
			int result = statement.executeUpdate();
			System.out.println("Record Inserted.");

		} catch (SQLException exception) {
			helper.showErrorMessage(exception);
		} finally {
			statement.close();
			connection.close();
		}
	}

	public static void selectData() throws SQLException {
		// select operation needs a resultset to hold data returned from sql query executions
		// and a data structure to store object which are holds transfered data from result set
		Connection connection = null;
		DbHelper helper = new DbHelper();
		Statement statement = null;
		ResultSet resultSet;
		try {
			connection = helper.getConnection();
			statement = connection.createStatement();
			// store the data returned database query
			resultSet = statement.executeQuery("select Code,Name,Continent,Region from country ");
			// store the objects 
			ArrayList<Country> countries = new ArrayList<Country>();
			// transfer datas from resultset to java objects and store them in a datastructure
			while (resultSet.next()) {
				countries.add(new Country(resultSet.getString("Code"), resultSet.getString("Name"),
						resultSet.getString("Continent"), resultSet.getString("Region")));
			}
			System.out.println(countries.size());

		} catch (SQLException exception) {
			helper.showErrorMessage(exception);
		} finally {
			connection.close();
		}
	}

	public static void updateData() throws SQLException {
		// same like insert operations just sql query and parameters changes
		Connection connection = null;
		DbHelper helper = new DbHelper();
		PreparedStatement statement = null;
		try {
			connection = helper.getConnection();
			String sql = "update city set population=100000,district='Turkey' where id = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, 4082);
			int result = statement.executeUpdate();
			System.out.println("Record Updated.");

		} catch (SQLException exception) {
			helper.showErrorMessage(exception);
		} finally {
			statement.close();
			connection.close();
		}
	}

	public static void deleteData() throws SQLException {
		// same like insert operations just sql query and parameters changes
		Connection connection = null;
		DbHelper helper = new DbHelper();
		PreparedStatement statement = null;
		try {
			connection = helper.getConnection();
			String sql = "delete from city where id = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, 4082);
			int result = statement.executeUpdate();
			System.out.println("Record Deleted.");

		} catch (SQLException exception) {
			helper.showErrorMessage(exception);
		} finally {
			statement.close();
			connection.close();
		}
	}
}
