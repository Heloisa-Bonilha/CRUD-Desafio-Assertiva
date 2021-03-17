package source;

import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
	ConectarDB db = new ConectarDB();
	//Comando delete SQL
	public boolean deleteSQL() throws SQLException {
		try {
			Statement statement = db.statementDB();
	    	statement.execute("DELETE FROM "+TabelaDB.getTabela()+" WHERE id ="+String.valueOf(Id.getId()));
	    	return true;
		}
		catch(SQLException e) {
			return false;
		}
	}
}
