import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory con=new ConnectionFactory();
		Connection connection=con.recuperarConexao();
		PreparedStatement stm=connection.prepareStatement("SELECT ID,NOME,CPF FROM ALUNO");
		stm.execute();
		ResultSet rst= stm.getResultSet();
		while(rst.next()) {
			Integer id=rst.getInt("ID");
			System.out.println(id);
			String nome=rst.getString("NOME");
			System.out.println(nome);
			String cpf=rst.getString("CPF");
			System.out.println(cpf);
	}
}
}
