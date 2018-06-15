

public class Transact {

	public static void main(String[] args) {
		
		BankAccount myAccount = new BankAccount(1000, "Jon", 23);
		
		if (myAccount.transaction(args))
		{
			System.out.println(myAccount.checkBalance());
		} else
		{
			System.out.println("ERROR");
		}
	}

}
