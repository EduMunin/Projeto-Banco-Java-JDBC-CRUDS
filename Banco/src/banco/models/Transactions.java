package banco.models;

import java.math.BigDecimal;
import java.security.Timestamp;

public class Transactions {
	private int transactionId;
	private int accountId;
	private String type;
	private BigDecimal amount;
	private Timestamp transactionDate;
	
	//construtor
	
	public Transactions(int accountId, String type, BigDecimal amount, Timestamp transationDate) {
		this.accountId = accountId;
		this.type = type;
		this.amount = amount;
		this.transactionDate = transationDate;
	}
	
	//gets
	
	public int getTransactionId() {return transactionId;}
	public int getAccountId() {return accountId;}
	public String getType() {return type;}
	public BigDecimal getAmout() {return amount;}
	public Timestamp getTransactionDate() {return transactionDate;}
	
	//sets
	
	public void setTransactionsId(int transactionsId) {this.transactionId = transactionsId;}
	public void setAccountId(int accountId) {this.accountId = accountId;}
	public void setType(String type) {this.type = type;}
	public void setAmout(BigDecimal amount) {this.amount = amount;}
	public void setTransactionDate(Timestamp transactionsDate) {this.transactionDate = transactionsDate;} 
}
