import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/*
 * Author Jonathan Farrell
 * The database class, represents an SQLite DB, implements IStorePatient for
 * abstraction, can be replaced by an data storage class that has a 
 * 'StorePatientDetails' method
 */

public class SQLiteDB implements IStorePatient {

	Connection c = null;
	Statement stmt = null;
	
	public SQLiteDB() {
		//connect to DB
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:MercyHospitalDB.sqlite");
			System.out.println("Connected to DB");
		}catch(Exception e) {
			System.out.println("Error 1: unable to connect to DB : " + e.getMessage());	
		}
	}
	@Override
	public void StorePatientDetails(String details) {
		try {
			this.stmt = c.createStatement();
			stmt.executeUpdate(details);
			System.out.println("Table updated");
		}catch(Exception e) {
			System.out.println("Error 4: Cannot execute SQL Query. " + e.getMessage() );
			e.printStackTrace();
		}
	}
}
