import static org.junit.Assert.*;

public class AccountTest {


	private Account account = new Account();

	@org.junit.Test
	public void printStatementTest() {
		account.deposit(1000);
		//setting the date of each case
		account.getTransactions().get(account.getTransactions().size() - 1).setDate("10/01/2012");
		account.deposit(2000);
		account.getTransactions().get(account.getTransactions().size() - 1).setDate("13/01/2012");
		account.withdraw(500);
		account.getTransactions().get(account.getTransactions().size() - 1).setDate("14/01/2012");
		account.printStatement();
	}
}
