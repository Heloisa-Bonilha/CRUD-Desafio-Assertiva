package source;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.sql.Statement;

import org.junit.BeforeClass;
import org.junit.Test;

public class ProcurarTest {
	static Procurar p = new Procurar();
	static ConectarDB db = new ConectarDB();
	static DadosView dados = new DadosView();
	static boolean var;
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
		st.execute("INSERT INTO tabela_teste(login,nome,senha)VALUE('teste Junit','JUnit',aes_encrypt('123','ctt'))");
		Procurar.setColuna("nome");
		Procurar.setTexto("JUnit");
		try {
			//Testa achar palavra
			String[][] dados =  p.procurar();
			if(dados[0][3].equals("JUnit")) {
				var = true;
			}
			else {
				var = false;
			}
		}
		catch(Exception e) {
			var = false;
		}
	}
}
