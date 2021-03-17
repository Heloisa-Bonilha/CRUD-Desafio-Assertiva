package source;

import static org.junit.Assert.*;

import org.junit.Test;

public class FormatacoesTest {
	Formatacoes f = new Formatacoes();
	@Test
	public void formatString() {
		assertEquals("1234-5678", f.formatString("12345678", "####-####") );
	}
	@Test
	public void converteData() {
		java.sql.Date data = java.sql.Date.valueOf("1998-11-11");
		assertEquals( data, f.converteData("11/11/1998") );
	}
	@Test
	public void converteDatatoString() {
		assertEquals("11/11/1998", f.converteDatatoString("1998-11-11"));
	}

}
