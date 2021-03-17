package source;

import static org.junit.Assert.*;

import org.junit.Test;

public class TabelaDBTest {
	@Test
	public void setTabela() {
		TabelaDB.setTabela("teste");
		assertEquals("teste", TabelaDB.getTabela());
	}

}
