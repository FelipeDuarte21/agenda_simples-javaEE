package logicas.contato;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContatoDAO;
import logicas.Logica;
import model.Contato;
import util.Mascara;

public class Alterar implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String opcao = req.getParameter("opcao");
		
		ContatoDAO contatoDao = (ContatoDAO) req.getAttribute("contatoDao");
		
		if(opcao.equals("1")) { //Tela
			
			int id = Integer.parseInt(req.getParameter("id"));
			
			Contato contato = contatoDao.buscarPorId(id);
			
			req.setAttribute("contato", contato);
			
			return "contato/alterar.jsp";
			
		}
		
		if(opcao.equals("2")) { //Atualizar
			
			Contato c = new Contato();
			
			c.setId(Integer.parseInt(req.getParameter("id")));
			c.setNome(req.getParameter("nome"));
			c.setCelular(Mascara.retiraMascaraCelularETelefone(req.getParameter("celular")));
			c.setTelefone(Mascara.retiraMascaraCelularETelefone(req.getParameter("telefone")));
			c.setEmail(req.getParameter("email"));
			
			contatoDao.alterar(c);
			
			return "contato/resultado.jsp";
			
		}
		
		return "";
	}

}
