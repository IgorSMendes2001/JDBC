import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaInsercaoComParametro {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory=new ConnectionFactory();
		Connection connection=factory.recuperarConexao();
		connection.setAutoCommit(false);
		try {
			PreparedStatement stm=connection.prepareStatement("INSERT INTO ALUNO (nome,cpf) VALUES(?,?)",Statement.RETURN_GENERATED_KEYS);
			adicionarVariavel("Gabi", "456879233", stm);
			adicionarVariavel("Silas","545648461", stm);
			connection.commit();
			stm.close();
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("ROLLBACK EXECUTADO");
			connection.rollback();
		}
		
	}

	private static void adicionarVariavel(String nome, String cpf, PreparedStatement stm) throws SQLException {
		stm.setString(1,nome);
		stm.setString(2,cpf);
		if(nome.equals("Silas")) {
			throw new RuntimeException("Não foi possível adicionar o produto " + nome);
		}
		stm.execute();
		ResultSet rst=stm.getGeneratedKeys();
		while(rst.next()) {
			Integer id=rst.getInt(1);
			System.out.println("O id criado foi: " + id);
		}
		rst.close();
	}
}
