package logicas.contato;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContatoDAO;
import logicas.Logica;
import model.Contato;
import model.Usuario;
import util.Mascara;

public class Cadastrar implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException  {
		
		String opcao = req.getParameter("opcao");
		
		if(opcao.equals("1")) { //Tela Cadastrar
			
			return "contato/cadastrar.jsp";
			
		}
		
		if(opcao.equals("2")) { //Cadastrar
			
			Usuario usuario = (Usuario) req.getAttribute("usuario");
			
			Contato c = new Contato();
			
			c.setNome(req.getParameter("nome"));
			c.setCelular(Mascara.retiraMascaraCelularETelefone(req.getParameter("celular")));
			c.setTelefone(Mascara.retiraMascaraCelularETelefone(req.getParameter("telefone")));
			c.setEmail(req.getParameter("email"));
			c.setUsuario(usuario);
			
			ContatoDAO contatoDao = (ContatoDAO) req.getAttribute("contatoDao");
			
			contatoDao.cadastrar(c);
			
			return "contato/resultado.jsp";
			
		}
		
		return "";
	}

}
