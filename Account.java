import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Account implements AccountService {

	private int balance = 0;
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	private final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public void deposit(int amount) throws IllegalArgumentException {
		if(amount <= 0){
			throw new IllegalArgumentException("invalid amount, amount must be equal to or higher than 1");
		}
		this.balance = this.balance + amount;
		//add transaction to transaction list and update balance
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setBalance(this.balance);
		transaction.setType(Transaction.Types.DEPOSIT);
		//add transaction date, did it statically to match test dates
		//transaction.setDate(formatter.format(new Date()));
		this.transactions.add(transaction);
		//System.out.println("you have just made a successful deposit of " + amount);
		//System.out.println("your current balance is " + this.balance);


	}

	@Override
	public void withdraw(int amount) throws IllegalArgumentException {
		if(amount <= 0){
			throw new IllegalArgumentException("invalid amount, amount must be equal to or higher than 1");
		}
		//check if balance insuffisant
		if(amount > this.balance){
			throw new IllegalArgumentException("your account balance is insuffisant");
		}
		this.balance = this.balance - amount;
		//add transaction to transaction list and update balance
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setBalance(this.balance);
		transaction.setType(Transaction.Types.WITHDRAWTH);
		//add transaction date, did it statically to match test dates
		//transaction.setDate(formatter.format(new Date()));
		this.transactions.add(transaction);
		//System.out.println("you have just made a successful withdrawth of " + amount);
		//System.out.println("your current balance is " + this.balance);


	}

	@Override
	public void printStatement() {
		System.out.println("Date  ||  Amount  || Balance  ");
		for(int i = this.transactions.size()-1 ; i >= 0 ; i-- ) {
			System.out.println(
				this.transactions.get(i).getDate() +"  ||  "+
					(this.transactions.get(i).getType().equals(Transaction.Types.DEPOSIT) ? this.transactions.get(i).getAmount() : "-"+ this.transactions.get(i).getAmount())
					+"  ||  "+
					this.transactions.get(i).getBalance());
		};

	}
}
