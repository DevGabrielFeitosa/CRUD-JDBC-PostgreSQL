package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.SingleConnection;
import model.Userposjava;

public class UserposDAO {

	private Connection connection;

	public UserposDAO() {
		connection = SingleConnection.getConnection();
	}

	public void salvar(Userposjava userPosJava) {
		try {

			String sql = "insert into userposjava (nome, email) values (?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, userPosJava.getNome());
			insert.setString(2, userPosJava.getEmail());
			insert.execute();
			connection.commit();

		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public List<Userposjava> listar() throws Exception {
		List<Userposjava> list = new ArrayList<Userposjava>();

		String sql = "select * from userposjava";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Userposjava userposjava = new Userposjava();
			userposjava.setId(resultSet.getLong("id"));
			userposjava.setNome(resultSet.getString("nome"));
			userposjava.setEmail(resultSet.getString("email"));

			list.add(userposjava);
		}

		return list;
	}

	public Userposjava buscar(Long id) throws Exception {
		Userposjava userposjava = new Userposjava();

		String sql = "select * from userposjava where id = " + id;
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			userposjava.setId(resultSet.getLong("id"));
			userposjava.setNome(resultSet.getString("nome"));
			userposjava.setEmail(resultSet.getString("email"));
		}

		return userposjava;
	}

	public void atualizar(Userposjava userposjava) {

		try {
			String sql = "update userposjava set nome = ? where id = " + userposjava.getId();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userposjava.getNome());

			preparedStatement.execute();
			connection.commit();
			connection.rollback();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deletar(Long id) {

		try {
		String sql = "delete from userposjava where id = " + id;
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.execute();
		connection.commit();
		connection.rollback();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}