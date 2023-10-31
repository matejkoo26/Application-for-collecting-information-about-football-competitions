import java.io.FileReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.util.Properties;

public class LoadJDBCSettingsFromPropertiesFileExample {

	public static void main(String[] args) {

		try
		{
			// Create Properties object.
			Properties props = new Properties();
			
			String dbSettingsPropertyFile = "src/main/resources/JDBCSettings.properties";

			FileReader fReader = new FileReader(dbSettingsPropertyFile);
			
			// Load jdbc related properties in above file. 
			props.load(fReader);
			
			// Get each property value.
			String dbDriverClass = props.getProperty("db.driver.class");
			
			String dbConnUrl = props.getProperty("db.conn.url");
			
			String dbUserName = props.getProperty("db.username");
			
			String dbPassword = props.getProperty("db.password");
			
			if(!"".equals(dbDriverClass) && !"".equals(dbConnUrl))
			{
				/* Register jdbc driver class. */
				Class.forName(dbDriverClass);
				
				// Get database connection object.
				Connection dbConn = DriverManager.getConnection(dbConnUrl, dbUserName, dbPassword);
				
				// Get dtabase meta data.
				DatabaseMetaData dbMetaData = dbConn.getMetaData();
				
				// Get database name.
				String dbName = dbMetaData.getDatabaseProductName();
				
				// Get database version.
				String dbVersion = dbMetaData.getDatabaseProductVersion();
				
				System.out.println("Database Name : " + dbName);
				
				System.out.println("Database Version : " + dbVersion);
			}
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
