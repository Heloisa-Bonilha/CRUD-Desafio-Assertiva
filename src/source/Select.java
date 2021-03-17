package source;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Select {
	ConectarDB db = new ConectarDB();
	public String[][] selectSQL() throws SQLException {
		Statement statement = db.statementDB();
		statement.executeQuery("SELECT * FROM "+TabelaDB.getTabela());
		ResultSet set = statement.getResultSet();
		//Pega quantidade de linhas do DB
		int j=0;
		while(set.next()) {
			j++;
		}
		statement.executeQuery("SELECT * FROM "+TabelaDB.getTabela());
		set = statement.getResultSet();
		ArrayList<String> colunas = new ArrayList<>(selectColunas());
		//Cria Matriz com os dados do DB
        String[][] dados = new String[j][colunas.size()];
		j=0;
        while(set.next()) {
        	for(int i =0; i< colunas.size();i++) {
        		dados[j][i] = set.getString(colunas.get(i));
        	}
        	System.out.println();
        	j++;
        }
        return dados;
	}
	//Metodo para pegar todos os IDs existentes do banco
	public ArrayList<Integer> selectId() throws SQLException {
		Statement statement = db.statementDB();
		statement.executeQuery("SELECT id FROM "+TabelaDB.getTabela());
        ArrayList<Integer> id = new ArrayList<>();
        ResultSet set = statement.getResultSet();
        while(set.next()) {
        	id.add(set.getInt(1));
        }
        return id;
	}
	//Metodo para pegar todas as colunas existentes do banco
	public ArrayList<String> selectColunas() throws SQLException {
		Statement statement = db.statementDB();
		statement.executeQuery("SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '"+TabelaDB.getTabela()+"'");
        
        ResultSet set = statement.getResultSet();
        LinkedHashSet<String> colunas = new LinkedHashSet<>();
        while(set.next()) {
        	colunas.add(set.getNString(1));
        }
        ArrayList<String> column = new ArrayList<>(colunas);

    	int id = column.indexOf("id");
    	String prim = column.get(0);
    	column.set(id, prim);
    	column.set(0, "id");
        
        return column;
	}
	//Metodo para pegar algum conteúdo específico do DB
	public String conteudoBanco(String nome) throws SQLException {
		Statement statement = db.statementDB();
    	statement.execute("SELECT "+nome+" FROM "+TabelaDB.getTabela()+" WHERE id ="+Id.getId());
    	ResultSet set = statement.getResultSet();
    	while(set.next()) {
    	String dadoDB = set.getString(1);
    	return dadoDB;
    	}
		return null;
	}
}
