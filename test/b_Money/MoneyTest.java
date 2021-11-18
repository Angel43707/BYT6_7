package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	Currency SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		SEK100 = new Money(10000.0, SEK);
		EUR10 = new Money(1000.0, EUR);
		SEK200 = new Money(20000.0, SEK);
		EUR20 = new Money(2000.0, EUR);
		SEK0 = new Money(0.0, SEK);
		EUR0 = new Money(0.0, EUR);
		SEKn100 = new Money(-10000.0, SEK);
	}

	@Test
	public void testGetAmount() {
		assertEquals(Double.valueOf(10000),SEK100.getAmount());
	}

	@Test
	public void testGetCurrency() {
		assertEquals(SEK, SEK100.getCurrency());
	}

	@Test
	public void testToString() {
		assertEquals("10000.0 SEK", SEK100.toString());
	}

	@Test
	public void testGlobalValue(){assertEquals(Double.valueOf(10000d * 0.15), SEK100.universalValue());
	}

	@Test
	public void testEqualsMoney() {
		assertFalse(SEK100.equals(SEK200));
		assertFalse(SEK0.equals(EUR0));
	}

	@Test
	public void testAdd() {
		assertEquals(SEK200.getAmount(), SEK100.add(SEK100).getAmount());
	}

	@Test
	public void testSub() {
		assertEquals(SEK100.getAmount(), SEK200.sub(SEK100).getAmount());
	}

	@Test
	public void testIsZero() {
		assertFalse(SEK100.isZero());
	}

	@Test
	public void testNegate() {
		assertEquals(Double.valueOf(-10000d), SEK100.negate().getAmount());
	}

	@Test
	public void testCompareTo() {
		assertEquals(1, SEK200.compareTo(SEK100));
		assertEquals(-1, SEK100.compareTo(SEK200));
	}
}
