package source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConectarDB {
	//Variaveis para conectar ao banco, j� iniciadas com os dados do meu (Helo�sa) DB
	//J� est�o iniciadas pois, ao criar o c�digo e modificar, n�o preciso setar toda vez
	private static String localhost="localhost";
	private static String database="desafio_assertiva";
	private static String nome="root";
	private static String senha="testemysql";
	//M�todo que conecta ao DB e retorna o Statement
	public Statement statementDB() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://"+localhost+"/"+database, nome, senha);
			Statement statement = connection.createStatement();
			return statement;
		}
		catch(SQLException e) {
			System.out.println("Erro: "+ e.getMessage());
			return null;
		}
		
	}
	//M�todo que conecta ao DB e retorna o Connection
	public Connection connectionDB() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://"+localhost+"/"+database, nome, senha);
			return connection;
		}
		catch(SQLException e) {
			System.out.println("Erro: "+ e.getMessage());
			return null;
		}
	}
	//M�todo que testa a tabela que o usu�rio inseriu no JFrame
	public ResultSet testarTabela() {
		try {
			Statement statement = statementDB();
			statement.executeQuery("SELECT * FROM "+TabelaDB.getTabela());
			ResultSet set = statement.getResultSet();
			return set;
		}
		catch(SQLException e) {
			System.out.println("Erro: "+ e.getMessage());
			return null;
		}
	}
	//M�todos que setam as variaveis
	public void setLocalhost(String localhost) {
		ConectarDB.localhost = localhost;
	}
	public void setDatabase(String database) {
		ConectarDB.database = database;
	}
	public void setNome(String nome) {
		ConectarDB.nome = nome;
	}
	public void setSenha(String senha) {
		ConectarDB.senha = senha;
	}
}
