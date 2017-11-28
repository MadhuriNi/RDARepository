package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class DBselect {

	Logger logger;
	Properties prop;
	Connection con;

	public ResultSet verifyDB() {
		ResultSet rs = null;

		try {

			readConfig rc = new readConfig();
			prop = rc.read();

			logged logg = new logged();
			logger = logg.getlogged("DBconnection");

			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@ldap://oid.inf.fedex.com:3060/GTM_PROD2_SVC1_L3,cn=OracleContext,dc=ute,dc=fedex,dc=com",
					"RSC_CR3", "fT6xEFj9wcTtdogXlY87RSCCR3");
			logger.info("The connection is created");

			Statement stmt = con.createStatement();
			logger.info("The statement is created");

			rs = stmt.executeQuery(prop.getProperty("select_sql"));
		}

		catch (SQLException e) {
			logger.info("The exception is " + e);
		} 
		
		return rs;

	}

}
