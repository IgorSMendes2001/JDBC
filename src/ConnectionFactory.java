import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection recuperarConexao()throws SQLException{
		return DriverManager.getConnection("jdbc:postgresql://localhost:54322/postgres","postgres","123456");
	}
}
