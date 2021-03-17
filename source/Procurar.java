package source;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Procurar {
	private static String texto;
	private static String nomeColuna;
	ConectarDB db = new ConectarDB();
	Select select = new Select();
	public String[][] procurar() throws SQLException {
		Statement statement = db.statementDB();
		//Pega quantidade de linhas que contém o texto digitado pelo usuario no JFrame
		statement.execute("SELECT * FROM "+TabelaDB.getTabela()+" WHERE "+nomeColuna+" like '%"+texto+"%'");
		ResultSet set = statement.getResultSet();
		int j=0;
		while(set.next()) {
			j++;
		}
		statement.execute("SELECT * FROM "+TabelaDB.getTabela()+" WHERE "+nomeColuna+" like '%"+texto+"%'");
		set = statement.getResultSet();
		ArrayList<String> colunas = new ArrayList<>(select.selectColunas());
        //Cria Matriz da qnt das linhas que contem o texto
		String[][] dados = new String[j][colunas.size()];
		j=0;
        while(set.next()) {
        	for(int i =0; i< colunas.size();i++) {
        		//Seta dados com conteúdo do DB
        		dados[j][i] = set.getString(colunas.get(i));
        	}
        	System.out.println();
        	j++;
        }
        return dados;
	}
	//Métodos para setar as variaveis
	public static void setTexto(String text) {
		texto = text;
	}
	public static void setColuna(String text) {
			nomeColuna= text;
	}
	public static String getColuna() {
		return nomeColuna;
	}
	public static String getTexto() {
		return texto;
	}
}
