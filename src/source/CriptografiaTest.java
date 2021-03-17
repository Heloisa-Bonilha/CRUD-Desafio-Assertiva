package source;

import static org.junit.Assert.*;

import org.junit.Test;

public class CriptografiaTest {
	Criptografia c = new Criptografia();
	@Test
	public void getCriptografia() {
		assertEquals("ctt", c.getCriptografia());
	}

}
