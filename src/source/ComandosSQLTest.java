package source;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;
public class ComandosSQLTest {
	
	@Test
	public void executeComandoSQL() throws SQLException {
		ComandosSQL sql = new ComandosSQL();
		assertEquals(true, sql.executeComandoSQL("SELECT * FROM "+TabelaDB.getTabela()));
	}
	@Test
	public void executeComandoSQLFalse() throws SQLException {
		ComandosSQL sql = new ComandosSQL();
		assertNotEquals(true, sql.executeComandoSQL("ERRO SELECT * FROM "+TabelaDB.getTabela()));
	}

}
