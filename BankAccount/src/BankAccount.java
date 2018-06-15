/**
 * A bank account has a balance that can be changed by deposits and withdrawals.
 * @author Jonathan
 *
 */
public class BankAccount {

	private double balance;
	
	private String name;
	
	private int accountNumber;
	
	public static final double INTEREST_RATE = 0.013;
	
	/**
	 * Constructs a bank account with a zero balance.
	 */
	public BankAccount()
	{
		balance = 0;
		name = "Jonathan";
		accountNumber = 23;
	}
	/**
	 * Constructs a bank account with an initial balance.
	 * @param initialBalance Starting balance amount.
	 * @param person
	 * @param accountNum
	 */
	public BankAccount(double initialBalance, String person, int accountNum)
	{
		balance = initialBalance;
		name = person; 
		accountNumber = accountNum;
	}
	/**
	 * Deposits money into the bank account.
	 * @param amount The amount to deposit.
	 */
	public void deposit(double amount)
	{
		balance = balance + amount;
	}
	/**
	 * Withdraws money into the bank account.
	 * @param amount Tha amount to withdraw.
	 */
	public void withdraw(double amount)
	{
		balance = balance - amount;
	}
	/**
	 * Gets the current balance of the bank account.
	 * @return The current balance.
	 */
	public double checkBalance()
	{
		return balance;
	}
		
	public String name()
	{
		return name;
	}
	
	public int accountNumber()
	{
		return accountNumber;
	}
	
	public double total(BankAccount bank)
	{
		return this.balance + bank.checkBalance();
	}
	
	public double transfer(double amountValue, BankAccount bankAccoun)
	{
		this.withdraw(amountValue);
		bankAccoun.deposit(amountValue);
		return this.checkBalance();
	}
	
	public String mystery(String name)
    {
        return this.name;
    }
	
	public double sum(BankAccount[] ba)
	{
		double total = 0;
				
		for(BankAccount each : ba)
		{
			if (each != this)
			{
				total = total + each.checkBalance();
			}
		}
		
		return total;
					
	}
	
	public double getInterest()
	{
		return this.balance * BankAccount.INTEREST_RATE;
	}
	
	public boolean transaction(String[] transactionType)
	{	
		if (transactionType.length > 0)
		{
			if (transactionType.length == 2)
			{
				if (transactionType[0].equals("deposit"))
				{
					this.deposit(Double.parseDouble(transactionType[1]));
				} else if (transactionType[0].equals("withdraw"))
				{
					this.withdraw(Double.parseDouble(transactionType[1]));
				} else
				{
					return false;
				}
				return true;
			} else if (transactionType.length == 1 && transactionType[0].equals("checkBalance"))
			{
				return true;
			}
		}
		return false;
	}
	
}
