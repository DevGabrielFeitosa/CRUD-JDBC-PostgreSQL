package servlets;

import java.io.IOException;

import dao.DAOLoginRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelLogin;

@WebServlet(urlPatterns = { "/principal/ServletLogin", "/ServletLogin" })
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DAOLoginRepository loginRepository = new DAOLoginRepository();

	public ServletLogin() {
	}

	/* Parâmetro pela URL para receber dados */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/* Parâmetro pelo form para receber dados */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("Login");
		String senha = request.getParameter("Senha");
		String url = request.getParameter("url");

			try {
				
				if (login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {
					ModelLogin modelLogin = new ModelLogin();
					modelLogin.setLogin(login);
					modelLogin.setSenha(senha);
		
						if (loginRepository.validarLogin(modelLogin)) {
			
							request.getSession().setAttribute("usuario", modelLogin.getLogin());
		
									if (url == null || url.equals("null")) {
										url = "principal/principal.jsp";
									}
					
									RequestDispatcher redirecionar = request.getRequestDispatcher(url);
									redirecionar.forward(request, response);
								} else {
									RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
									request.setAttribute("msg", "Login ou senha inválidos");
									redirecionar.forward(request, response);
								}
		
				} else {
					RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
					request.setAttribute("msg", "Login ou senha inválidos");
					redirecionar.forward(request, response);
				}
			} catch (Exception e) {
					e.printStackTrace();
					RequestDispatcher redirecionar = request.getRequestDispatcher("erro.jsp");
					request.setAttribute("msg", e.getMessage());
					redirecionar.forward(request, response);
					
				}
	}
} 

