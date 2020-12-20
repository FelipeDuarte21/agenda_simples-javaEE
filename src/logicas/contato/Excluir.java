package logicas.contato;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContatoDAO;
import logicas.Logica;

public class Excluir implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ContatoDAO contatoDao = (ContatoDAO) req.getAttribute("contatoDao");
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		contatoDao.excluir(id);
		
		return "contato/resultado.jsp";
		
	}

}
