package helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class StudentHelperClass {
	Properties properties = new Properties();
	Connection connection=null;
	public Connection helperMethod() {
		try {
			InputStream fileInputStream = new FileInputStream("Sudentfile.properties");
			properties.load(fileInputStream);
			String driver=properties.getProperty("driver");
			String url=properties.getProperty("url");
			Class.forName(driver);
			connection=DriverManager.getConnection(url, properties);
			
		} catch (IOException | ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return connection;

	}

}
