package source;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Decrypt {
	private static String sql;
	ConectarDB db = new ConectarDB();
	static Select select = new Select();
	static Criptografia c = new Criptografia();
	private static ArrayList<String> colunas;
	private static String column;
	//Método que pega os dados decriptados
	public String[][] decrypt() throws SQLException {
		Statement statement = db.statementDB();
		statement.executeQuery(sql);
		ResultSet set = statement.getResultSet();
		//Pega o tamanho das linhas do DB
		int j=0;
		while(set.next()) {
			j++;
		}
		setColumn();
		statement.executeQuery(sql);
		set = statement.getResultSet();
		//Cria Matriz com o tamanho do DB, precisa ser Matriz para mostrar na tabela do JFrame
		String[][] dados = new String[j][colunas.size()];
		j=0;
        while(set.next()) {
        	for(int i =0; i< colunas.size();i++) {
        		//Seta dados com o conteúdo do DB
        		dados[j][i] = set.getString(colunas.get(i));
        	}
        	j++;
        }
        return dados;
	}
	//Seta a String de comando sql
	public static void setStringSQL(String comando) {
		sql = comando;
		
	}
	//Pega colunas do DB e troca senha com o código para decriptar
	public static void setColumn() throws SQLException {
		colunas = new ArrayList<>(select.selectColunas());
		colunas.set(colunas.indexOf("senha"), colunas.get(colunas.indexOf("senha")).replaceFirst("senha", "aes_decrypt(senha,'"+c.getCriptografia()+"')"));
        column = colunas.toString().substring(1, colunas.toString().length()-1);
	}
	public static String getColumn() {
		return column;
	}
}
