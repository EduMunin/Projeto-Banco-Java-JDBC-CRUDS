package banco.models;

import java.math.BigDecimal;

public class Accounts {
	private int accountId;
	private int userId;
	private BigDecimal balance;
	
	//construtor
	
	public Accounts(int userId, BigDecimal balance) {
		this.balance = balance;
		this.userId = userId;
	}
	
	//gets
	
	public int getAccountId() {return accountId;}
	public int getUserId() {return userId;}
	public BigDecimal getBalance() {return balance;}
	
	//sets
	
	public void setAccountId(int accountId) {this.accountId = accountId;}
	public void setUserId(int userId) {this.userId = userId;}
	public void setBalance(BigDecimal balance){this.balance = balance;}
	

}
