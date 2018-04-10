package controlleur;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDAOPostegresql {

	public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://localhost:5432/Tuto";
			String user = "postgres";
			String passwd ="vanda91";

			Connection conn =  DriverManager.getConnection(url, user, passwd);
			return conn;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	} 
}