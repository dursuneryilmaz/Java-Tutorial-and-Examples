package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
	// to connect any data base username,password and db url must be specified
    private String userName="root";
    private String password="12345";
    private String dbUrl ="jdbc:mysql://localhost:3306/world?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public Connection getConnection() throws SQLException {
    	// driver manager gets a connection from used database engine
        return DriverManager.getConnection(dbUrl,userName,password);
    }

    public void showErrorMessage(SQLException exception){
        System.out.println("Error : "+ exception.getMessage());
        System.out.println("Error code : "+ exception.getErrorCode());
    }
}
