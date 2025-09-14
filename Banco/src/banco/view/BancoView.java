package banco.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import banco.util.DatabaseConnection;
import banco.models.Accounts;
import banco.models.Transactions;
import banco.models.Users;

public class BancoView {
	private Scanner scanner;
	
	public void StartMenu() {
		System.out.println("1 - Login");
		System.out.println("2 - Register");
		System.out.println("3 - Admin Login");
	}
	
	public void AccoountMenu() {
		System.out.println("1 - Whitdraw");
		System.out.println("2 - Deposit");
		System.out.println("3 - Transfer");
		System.out.println("4 - Show Balance");
	}
	
	public void AdminMenu() {
		System.out.println("1 - ShowAllUsers");
		System.out.println("2 - DeleteUser");
		System.out.println("3 - ShowAllAccounts");
	}
	
	public int ReadOption() {
		try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Erro: Digite um número válido!");
            scanner.nextLine();
            return -1;
        }
        finally {
            scanner.nextLine(); // Consumir a nova linha
        }
    }
	
	public void ShowMessage(String massage) {
		System.out.println(massage);
	}
	
	public void ShowAllUsers(List<Users> ListUsers) {
		for (Users users : ListUsers) {
			System.out.println("Id: " + users.getId() + "Name: " + users.getName() + " || " + "CPF: " + users.getCpf());
			System.out.println("Password: " + users.getpassword());
			System.out.println("--------------------------------------------------------------");
		}
	}
	
	public void ShowAllAccounts(List<Accounts> ListAccounts) {
		for (Accounts accounts : ListAccounts) {
			System.out.println("Id: " + accounts.getAccountId() + "UserId: " + accounts.getUserId() + "Balance: " + accounts.getBalance());
		}
		
	}
	
	public void ShowAllTransactions(List<Transactions> ListTransactions) {
		for (Transactions transactions : ListTransactions) {
			System.out.println("Id transaction: " + transactions.getTransactionId() + "Id account: " + transactions.getAccountId());
			System.out.println("Type: " + transactions.getType() + "Amout: " + transactions.getAmout() + "Date: " + transactions.getTransactionDate());
		}
	}
	
	public void ShowBalance(int IdAccount) {
		String sql = "SELECT balance FROM Accounts WHERE id = ?";
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			stmt.setInt(1, IdAccount);
			System.out.println("Balance: " + rs.getBigDecimal(IdAccount));
			
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void ShowTransactions(Transactions transaction) {
		System.out.println("IdTransaction: " + transaction.getTransactionId() + "IdAccount " + transaction.getAccountId());
		System.out.println("Type: " + transaction.getType() + "Amout: " + transaction.getAmout());
	}
	
	public void ShowUser(Users user) {
		System.out.println("Id: " + user.getId() + "CPF: " + user.getCpf() + "Name: " + user.getName() + "PassWord: " + user.getpassword());
	}
	
	public void ShowAccount(Accounts account) {
		System.out.println("Id: " + account.getAccountId() + "IdUser: " + account.getUserId() + "Balance: " + account.getBalance());
	}
	
}
