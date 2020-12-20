package logicas.usuario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import logicas.Logica;
import model.Usuario;

public class Cadastrar implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String opcao = req.getParameter("opcao");
		
		if(opcao.equals("1")) {
			return "usuario/cadastrar.jsp";
		}
		
		if(opcao.equals("2")) {
			
			Usuario usuario = new Usuario();
			usuario.setNome(req.getParameter("nome"));
			usuario.setEmail(req.getParameter("email"));
			usuario.setSenha(req.getParameter("senha"));
			
			UsuarioDAO usuarioDao = (UsuarioDAO) req.getAttribute("usuarioDao");
			
			usuarioDao.cadastrar(usuario);
			
			return "usuario?acao=login&opcao=1";
			
		}
		
		return "";
	}

}