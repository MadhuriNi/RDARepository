package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class DBinsert {

	Logger logger;
	Properties prop;
	PreparedStatement ps;
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

			ps = con.prepareStatement(prop.getProperty("insert_sql"));
			logger.info("Statement created");
		} 
		catch (Exception e) {
			System.out.println("The exception is "+e);
		}
		

	}

	public void insert(String jobid, String device, int testid, String trkngnbr, String wording, String actual) {

		try {
			
			ps.setString(1, jobid);
			ps.setString(2, device);
			ps.setInt(3, testid);
			ps.setString(4, trkngnbr);
			ps.setString(5, "REPORT_RDA");
			ps.setString(6, wording);
			ps.setString(7, actual);
			ps.setString(8, "1111");

			ps.addBatch();

		}

		catch (SQLException e) {
			logger.info("The exception is " + e);
		}

	}

	public void insert_batch() throws SQLException {
		try {
			int[] a = ps.executeBatch();
			logger.info("Insert executed !!!!!!");
		} catch (SQLException e) {
			System.out.println("The exception is " + e);
		} finally {
			ps.close();
			con.close();
			logger.info("In finally method");
		}

	}
}
