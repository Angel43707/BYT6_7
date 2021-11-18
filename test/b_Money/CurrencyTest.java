package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;
	
	@Before
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}

	@Test
	public void testGetName() {
		assertEquals("SEK", SEK.getName());
	}
	
	@Test
	public void testGetRate() {
		assertEquals(Double.valueOf(0.20), DKK.getRate());
	}
	
	@Test
	public void testSetRate() {
		SEK.setRate(0.25);
		assertEquals(Double.valueOf(0.25), SEK.getRate());
	}
	
	@Test
	public void testGlobalValue() {
		assertEquals(Double.valueOf(15d), SEK.universalValue(100.0));
	}
	
	@Test
	public void testValueInThisCurrency() {
		assertEquals(Double.valueOf(1000d), SEK.valueInThisCurrency(100d, EUR));
	}

}
