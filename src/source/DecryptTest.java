package source;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.sql.Statement;

import org.junit.BeforeClass;
import org.junit.Test;

public class DecryptTest {
	static ConectarDB db = new ConectarDB();
	static boolean var;
	static Decrypt d = new Decrypt();
	@Test
	public void testDecrypt() throws SQLException {
		assertTrue(var);
	}
	//Para os teste que envolvem o banco de dados, foi criado um banco de teste para testar as operações, sem que comprometa o banco real
	@BeforeClass
	public static void setBancoTeste() throws SQLException {
		Statement st = SetBancoTeste.setBancoDadosTeste();
		//Zera o banco de dados
		st.execute("DELETE FROM tabela_teste");
		//Insere os dados
		st.execute("INSERT INTO tabela_teste(login,nome,senha)VALUE('teste Junit','JUnit',aes_encrypt('123','ctt'))");
		String[][] dados = d.decrypt();
		//Verifica senha decriptada
		if(dados[0][4].equals("123")) {
			var = true;
		}
		else {
			var = false;
		}
	}
}
