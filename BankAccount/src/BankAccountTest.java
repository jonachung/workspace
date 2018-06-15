import org.junit.Assert;

import org.junit.Test;

public class BankAccountTest {

	@Test
	public void testConstructor1() {
		BankAccount myAccount = new BankAccount();
		Assert.assertEquals(0.0, myAccount.checkBalance(), 0.0);
	}
	
	@Test
	public void testConstructor2()
	{
		BankAccount myAccount = new BankAccount(30.0, "JOnathan", 23);
		Assert.assertEquals(30.0, myAccount.checkBalance(), 0.0);

	}
	
	@Test
	public void testDeposit()
	{
		BankAccount myAccount = new BankAccount(19.25, "JOnathan", 23);
		Assert.assertEquals(19.25, myAccount.checkBalance(), 0.0);
		myAccount.deposit(2.75);
		Assert.assertEquals(22.00, myAccount.checkBalance(), 0.0);

	}

}
