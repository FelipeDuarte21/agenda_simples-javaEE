package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContatoDAO;
import logicas.Logica;
import model.Usuario;

@WebServlet("/contato")
public class ContatoController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		req.setAttribute("usuario", (Usuario) req.getSession().getAttribute("usuario"));
		
		Connection conexao = (Connection) req.getAttribute("conexao");
		req.setAttribute("contatoDao", ContatoDAO.getInstancia(conexao));
		
		String acao = req.getParameter("acao");
		acao = acao.substring(0,1).toUpperCase().concat(acao.substring(1));
		
		try {
			
			Class<?> classe = Class.forName("logicas.contato." + acao);
			
			Logica logica = (Logica) classe.getDeclaredConstructor().newInstance();
			String pagina = logica.executa(req, resp);
			
			req.getRequestDispatcher(pagina).forward(req, resp);
			
		} catch (Exception e1) {
			System.out.println("Erro ao instanciar classe referente a logica do contato");
			e1.printStackTrace();
		} 
		
	}
	
}
