package banco.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import banco.util.DatabaseConnection;
import banco.models.Users;

public class UsersDAO{
	
	public void createUser(Users user) throws SQLException {
		String sql = "INSERT INTO users(name, CPF, password) VALUES(?, ?, ?);";
		
		try(Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql)) {
		stmt.setString(1, user.getName());
		stmt.setString(2, user.getCpf());
		stmt.setString(3, user.getpassword());
		stmt.executeUpdate();
		conn.close();
		} catch(SQLException e){
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public List<Users> ListUsers() throws SQLException{
		List<Users> UsersList = new ArrayList<>();
		String sql = "SELECT * FROM users";
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()){
			while (rs.next()) {
				Users user = new Users(rs.getString("name"), rs.getString("cpf"), rs.getString("password"));
				user.setId(rs.getInt("id"));
				UsersList.add(user);
			}
		}
		return UsersList;	
	}
	
	public boolean deleteUser(int id) throws SQLException{
		String sql = "DELETE FROM users WHERE id = ?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setInt(1, id);
			return stmt.executeUpdate() > 0;
		}
	}
	
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
