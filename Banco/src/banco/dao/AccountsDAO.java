package banco.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import banco.util.DatabaseConnection;

public class AccountsDAO {

	public boolean whitdraw(int id, BigDecimal value) throws SQLException {
		String sql = "UPDATE users SET balance = ? WHERE id = ? AND balance >= ?";
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setBigDecimal(1, value);
			stmt.setInt(2, id);
			stmt.setBigDecimal(3, value);
			return stmt.executeUpdate() > 0;
		}
	}
	
	public boolean deposit(int id, BigDecimal value) throws SQLException {
		String sql = "UPDATE users SET balance = ? WHERE id = ?";
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setBigDecimal(1, value);
			stmt.setInt(2, id);
			return stmt.executeUpdate() > 0;
		}
	}
	
	public boolean transferFunds(int idWhitdraw, int idDeposit, BigDecimal value) throws SQLException {
		//add money
		String sql = "UPDATE users SET balance = ? WHERE id = ?";
		try(Connection conn = DatabaseConnection.getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(sql)) {
					stmt.setBigDecimal(1, value);
					stmt.setInt(2, idDeposit);
					stmt.executeUpdate();
					if (stmt.executeUpdate() <= 0) {
						System.out.println("Erro transferFunds in Deposit");
						return false;
					}
			
		} 
				String sql2 = "UPDATE users SET balance = ? WHERE id = ? AND balance >= ?";
				try(Connection conn = DatabaseConnection.getConnection();
						PreparedStatement stmt = conn.prepareStatement(sql2)) {
					stmt.setBigDecimal(1, value);
					stmt.setInt(2, idWhitdraw);
					stmt.setBigDecimal(3, value);
					return stmt.executeUpdate() > 0;
				}
	}
}
