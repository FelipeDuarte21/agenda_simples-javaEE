package logicas.usuario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioDAO;
import logicas.Logica;
import model.Usuario;

public class Login implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String opcao = req.getParameter("opcao");
		
		if(opcao.equals("1")) {
			return "login.jsp";
		}
		
		if(opcao.equals("2")) {
		
			Usuario usuario = new Usuario();
			usuario.setEmail(req.getParameter("email"));
			usuario.setSenha(req.getParameter("senha"));
			
			UsuarioDAO usuarioDao = (UsuarioDAO) req.getAttribute("usuarioDao");
			
			usuario = usuarioDao.buscarPorEmailESenha(usuario);
			
			if(usuario == null) {
				return "usuario?acao=login&opcao=1";
			}
			
			HttpSession session = req.getSession();
			
			session.setAttribute("usuario", usuario);
			
			return "contato?acao=listar";
		
		}
		
		return "";		
	}

}
