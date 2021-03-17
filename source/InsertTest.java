package source;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.sql.Statement;

import org.junit.BeforeClass;
import org.junit.Test;

public class InsertTest {
	static Insert i = new Insert(); 
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
		dados.setDadosZero();
		//Insere os dados
		dados.setDadosInsert("JUnit");
		dados.setDadosInsert("JUnit");
		dados.setDadosInsert("JUnit");
		try {
			var = i.insertSQL();
			
		}
		catch(Exception e) {
			var = false;
		}
	}

}
