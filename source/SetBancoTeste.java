package source;

import java.sql.Statement;

public class SetBancoTeste {
	static ConectarDB db = new ConectarDB();
	//Classe somente para teste no JUnit
	//Foi criado um banco de dados de teste (vazio) para testar as operações do banco
	public static Statement setBancoDadosTeste() {
		db.setLocalhost("localhost");
		db.setDatabase("banco_de_teste");
		db.setNome("root");
		db.setSenha("testemysql");
		TabelaDB.setTabela("tabela_teste");
		Statement st = db.statementDB();
		return st;
	}
}
