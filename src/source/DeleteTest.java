package source;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.sql.Statement;

import org.junit.BeforeClass;
import org.junit.Test;

public class DeleteTest {
	static ConectarDB db = new ConectarDB();
	static boolean var;
	static Select s = new Select();
	static Delete del = new Delete();
	@Test
	public void test() {
		assertTrue(var);
	}
	//Para os teste que envolvem o banco de dados, foi criado um banco de teste para testar as operações, sem que comprometa o banco real
	@BeforeClass
	public static void setBancoTeste() throws SQLException {
		Statement st = SetBancoTeste.setBancoDadosTeste();
		//Zera o banco de dados
		st.execute("DELETE FROM tabela_teste");
		//Insere os dados
		st.execute("INSERT INTO tabela_teste(login,nome,senha)VALUE('teste JUnit','JUnit',aes_encrypt('123','ctt'))");
		String[][] dados = s.selectSQL();
		try {
			//Testa delete pelo ID
			Id id = new Id();
			id.setId(Integer.parseInt(dados[0][0]));
			var = del.deleteSQL();
			
		}
		catch(Exception e) {
			var = false;
		}
	}
}
