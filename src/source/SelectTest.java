package source;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

public class SelectTest {
	static ConectarDB db = new ConectarDB();
	static boolean var;
	static int id;
	static Select s = new Select();
	static Id i = new Id();
	@Test
	public void selectSQL() {
		assertTrue(var);
	}
	@Test
	public void selectId() throws SQLException {
		ArrayList<Integer> ids = s.selectId();
		assertTrue(ids.contains(Id.getId()));
	}
	@Test
	public void selectColunas() throws SQLException {
		ArrayList<String> colunas = s.selectColunas();
		assertTrue(colunas.contains("nome"));
	}
	@Test
	public void conteudoBanco() throws SQLException {
		String conteudo = s.conteudoBanco("login");
		assertTrue(conteudo.contains("teste JUnit"));
	}

	//Para os teste que envolvem o banco de dados, foi criado um banco de teste para testar as operações, sem que comprometa o banco real
	@BeforeClass
	public static void setBancoTeste() throws SQLException {
		Statement st = SetBancoTeste.setBancoDadosTeste();
		//Zera o banco de dados
		st.execute("DELETE FROM tabela_teste");
		//Insere os dados
		st.execute("INSERT INTO tabela_teste(login,nome,senha)VALUE('teste JUnit','JUnit',aes_encrypt('123','ctt'))");
		try {
			String[][] dados = s.selectSQL();
			i.setId(Integer.parseInt(dados[0][0]));
			if(dados[0][3].contains("JUnit")) {
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
