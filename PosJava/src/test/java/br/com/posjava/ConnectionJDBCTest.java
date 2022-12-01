package br.com.posjava;

import java.util.List;

import org.junit.Test;

import dao.TelefoneDAO;
import dao.UserposDAO;
import model.BeanUser;
import model.Telefoneposjava;
import model.Userposjava;

public class ConnectionJDBCTest {

	@Test
	public void initBanco() {
		UserposDAO userposDAO = new UserposDAO();
		Userposjava userposjava = new Userposjava();

		userposjava.setNome("teste1");
		userposjava.setEmail("teste1@gmail.com");

		userposDAO.salvar(userposjava);

		System.out.println("Conexão com sucesso");
	}

	@Test
	public void initLista() throws Exception {
		UserposDAO userposDAO = new UserposDAO();
		List<Userposjava> lista = userposDAO.listar();

		for (Userposjava userposjava : lista) {
			System.out.println(userposjava + "\n");
		}

	}

	@Test
	public void initBusca() throws Exception {
		UserposDAO userposDAO = new UserposDAO();
		Userposjava userposjava = userposDAO.buscar(2L);

		System.out.println(userposjava);
	}

	@Test
	public void initAtualizacao() {
		UserposDAO userposDAO = new UserposDAO();

		try {
			Userposjava userposjava = userposDAO.buscar(2L);

			userposjava.setNome("Nome atualizado");

			userposDAO.atualizar(userposjava);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void initDelete() {
		try {

			UserposDAO dao = new UserposDAO();
			dao.deletar(5L);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void initTelefone() {

		TelefoneDAO telefoneDAO = new TelefoneDAO();
		Telefoneposjava telefoneposjava = new Telefoneposjava();

		telefoneposjava.setNumero("(21)0000-1111");
		telefoneposjava.setTipo("ABC");
		telefoneposjava.setUsuariopessoa(1L);

		telefoneDAO.salvarTelefone(telefoneposjava);

	}

	@Test
	public void initInnerJoin() {

		TelefoneDAO dao = new TelefoneDAO();
		List<BeanUser> list = dao.beanUsers(4L);
		
		for (BeanUser beanUser : list) {
			System.out.println(beanUser + "\n");
		}
		
	}

	@Test
	public void deletePaiFilho() {
		
		TelefoneDAO dao = new TelefoneDAO();
		dao.deletePaiFilho(4L);
		
	}
	
}
