package helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class HelperClassProduct {
	Properties property=new Properties();
	Connection connection=null;

	public Connection helperMethod() {
		try {
			InputStream inputStream=new FileInputStream("conn.properties");
			property.load(inputStream);
			String url=property.getProperty("url");
			String driver=property.getProperty("driver");
			Class.forName(driver);
		connection=DriverManager.getConnection(url,property);
			
		} catch (IOException | ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return connection;
	}
	

}
