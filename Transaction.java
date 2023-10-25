import java.util.Date;

public class Transaction {

	private int amount;
	private String date;

	private Types type;

	private int balance;


	public int getBalance() {
		return balance;
	}

	public String getDate() {
		return date;
	}

	public int getAmount() {
		return amount;
	}

	public Types getType() {
		return type;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setType(Types type) {
		this.type = type;
	}

	enum Types {
		DEPOSIT,
		WITHDRAWTH
	}
}
