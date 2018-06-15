
public class AccountTester {

	public static void main(String[] args) {
		BankAccount dadsChecking = new BankAccount(10, "Dad", 23);
		BankAccount myAccount = new BankAccount(60, "Jonathan", 30);
		System.out.println(myAccount.checkBalance());
		System.out.println(myAccount.transfer(10, dadsChecking));
		System.out.println(dadsChecking.checkBalance());
		System.out.println(myAccount.getInterest());
		
		
		//BankAccount[] ba = new BankAccount[3];
		//ba[0] = new BankAccount(7);
		//ba[1] = new BankAccount(14);
		//ba[2] = new BankAccount(21);
		
		//System.out.println(ba[1].sum(ba)); //Prints out 28
	}

}
