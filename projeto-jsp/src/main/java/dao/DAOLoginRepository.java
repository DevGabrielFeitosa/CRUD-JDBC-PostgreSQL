package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.SingleConnection;
import model.ModelLogin;

public class DAOLoginRepository {

	
	private Connection connection;
	
	public DAOLoginRepository() {
		connection = SingleConnection.getConnection();
	}
	
	public boolean validarLogin(ModelLogin login) throws Exception {
		
		String sql = "select * from model_login where login = ? and senha = ?";
	
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, login.getLogin());
		statement.setString(2, login.getSenha());
	
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			return true;
		} else {
			return false;
		}
	}
	
}
