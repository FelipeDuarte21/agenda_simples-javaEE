package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import logicas.Logica;

@WebServlet("/usuario")
public class UsuarioController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Connection conexao = (Connection) req.getAttribute("conexao");
		
		req.setAttribute("usuarioDao", UsuarioDAO.getInstancia(conexao));
		
		String acao = req.getParameter("acao");
		
		acao = acao.substring(0,1).toUpperCase().concat(acao.substring(1)); 
		
		try {
			Class<?> classe = Class.forName("logicas.usuario." + acao);
			
			Logica logica = (Logica) classe.getDeclaredConstructor().newInstance();
			
			String dispatcher = logica.executa(req, resp);
			
			req.getRequestDispatcher(dispatcher).forward(req, resp);
			
		} catch (Exception e) {
			System.out.println("Erro ao executar acão de login ou logout");
			e.printStackTrace();
		}
		
	}
	
}
