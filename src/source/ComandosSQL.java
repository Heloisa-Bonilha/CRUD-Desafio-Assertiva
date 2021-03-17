package source;

import java.sql.SQLException;

import java.sql.Statement;

public class ComandosSQL {
	ConectarDB db = new ConectarDB();
	//metodo que executa o comando digitado pelo usuario, sem tratamentos prévios.  
    public boolean executeComandoSQL(String comando) throws SQLException {
    	try {
    	Statement statement = db.statementDB();
    	statement.execute(comando);
    	return true;
    	}
    	catch(SQLException e ) {
    		e.printStackTrace();
    		return false;
    	}
    }

}
