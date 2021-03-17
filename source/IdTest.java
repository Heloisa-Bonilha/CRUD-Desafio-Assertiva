package source;

import static org.junit.Assert.*;

import org.junit.Test;

public class IdTest {
	Id id = new Id();
	@Test
	public void setId() {
		id.setId(2);
		assertEquals(2,Id.getId());
	}

}
