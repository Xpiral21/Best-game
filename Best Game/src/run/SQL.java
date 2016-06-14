package run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL {
	static void recordHighScore(String Name, int Score) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {

			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return;
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "STUDENT", "STUDENT");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("INSERT INTO HIGHSCORE VALUES('" + Name + "'," + Score + ")");
			connection.close();
		} catch (Exception e)

		{
			System.out.println(e);
		}

	}

	    static void getHighScores() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {

			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return;
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@86.124.147.162:1521/xe", "STUDENT", "STUDENT");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM HIGHSCORE ");
			System.out.println("Top Players");
			while (rs.next())
				System.out.println(rs.getString(1) + "  " + rs.getInt(2));
			connection.close();
		} catch (Exception e)

		{
			System.out.println(e);
		}
	}
}
