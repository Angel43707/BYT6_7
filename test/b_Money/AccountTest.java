package b_Money;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
	Currency SEK, DKK;
	Bank Nordea;
	Bank DanskeBank;
	Bank SweBank;
	Account testAccount;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		SweBank.openAccount("Alice");
		SweBank.openAccount("Stive");
		testAccount = new Account("Hans", SEK);
		testAccount.deposit(new Money(10000000.0, SEK));

		SweBank.deposit("Alice", new Money(1000000.0, SEK));
	}
	
	@Test
	public void testAddRemoveTimedPayment() {
		testAccount.addTimedPayment("1", 300, 2, new Money(100d, SEK), SweBank, "Stive");
		assertTrue(testAccount.timedPaymentExists("1"));
		testAccount.removeTimedPayment("1");
		assertFalse(testAccount.timedPaymentExists("1"));
	}

	@Test(expected = AccountDoesNotExistException.class)
	public void testTimedPayment() throws AccountDoesNotExistException {
		testAccount.addTimedPayment("1", 300, 0, new Money(100d, SEK), SweBank, "Ben");
		testAccount.tick();
	}

	@Test
	public void testAddWithdraw() {
		testAccount.withdraw(new Money(5000000d, SEK));
		assertTrue(testAccount.getBalance().equals(new Money(5000000d, SEK)));
	}
	
	@Test
	public void testGetBalance() {
		assertTrue(testAccount.getBalance().equals(new Money(10000000d, SEK)));
	}
}
