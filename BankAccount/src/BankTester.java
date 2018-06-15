
public class BankTester {

	public static void main(String[] args) {
        //BankAccount mySavings = new BankAccount();
        //BankAccount dadsSavings = new BankAccount();
        BankAccount momsSavings = new BankAccount(1000, "mum", 0);
        //System.out.println(mySavings.checkBalance());
        //System.out.println(dadsSavings.checkBalance());
        //System.out.println(momsSavings.checkBalance());
        //System.out.println(momsSavings.transaction("checkBalance");
		
        System.out.println(momsSavings.transaction("deposit", "10"));
    }

}
