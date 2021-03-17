package source;

import static org.junit.Assert.*;


import org.junit.Test;

public class DadosViewTest {
	DadosView d = new DadosView();
	@Test
	public void setDadosInsert() {
		d.setDadosZero();
		assertEquals(d.getDados(), d.setDadosInsert("heloisa"));
	}
	@Test
	public void setDadosZero() {
		assertEquals("[]", d.setDadosZero().toString());
	}

}
