package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DBopenConnection {
	
	Logger logger;
	Properties prop;
	Connection con;
	
	public void open_connection() {
		try {
			
			logged logg = new logged();
			logger = logg.getlogged("DBinsert");

			readConfig rc = new readConfig();
			prop = rc.read();
			
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@ldap://oid.inf.fedex.com:3060/GTM_PROD2_SVC1_L3,cn=OracleContext,dc=ute,dc=fedex,dc=com",
					"RSC_CR3", "fT6xEFj9wcTtdogXlY87RSCCR3");
			
			logger.info("Connection created");

		} 
		catch (Exception e) {
			System.out.println("The exception is "+e);
		}
		

	}

}
