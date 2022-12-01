package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.SingleConnection;
import model.BeanUser;
import model.Telefoneposjava;

public class TelefoneDAO {

	private Connection connection;

	public TelefoneDAO() {
		connection = SingleConnection.getConnection();
	}

	public void salvarTelefone(Telefoneposjava telefone) {

		try {

			String sql = "INSERT INTO public.telefoneuser (numero, tipo, usuariopessoa) VALUES (?, ?, ?);";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, telefone.getNumero());
			preparedStatement.setString(2, telefone.getTipo());
			preparedStatement.setLong(3, telefone.getUsuariopessoa());
			preparedStatement.execute();
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

	public List<BeanUser> beanUsers(Long idUser) {

		List<BeanUser> list = new ArrayList<BeanUser>();

		String sql = "select * from telefoneuser as fone inner join userposjava as java on fone.usuariopessoa = java.id where usuariopessoa = " + idUser;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					
					BeanUser beanUser = new BeanUser();
					beanUser.setNome(resultSet.getString("nome"));
					beanUser.setNumero(resultSet.getString("numero"));
					beanUser.setTipo(resultSet.getString("tipo"));
					list.add(beanUser);
				}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public void deletePaiFilho(Long id) {
		
		String sqlFilho = "delete from telefoneuser where usuariopessoa = " + id;
		String sqlPai = "delete from userposjava where id = " + id;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlFilho);
			preparedStatement.executeUpdate();
			connection.commit();
			
			PreparedStatement preparedStatement2 = connection.prepareStatement(sqlPai);
			preparedStatement2.executeUpdate();
			connection.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
