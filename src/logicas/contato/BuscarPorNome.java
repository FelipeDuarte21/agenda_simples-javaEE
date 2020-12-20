package logicas.contato;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import componentes.paginacao.Pagina;
import componentes.paginacao.PaginaComponent;
import dao.ContatoDAO;
import logicas.Logica;
import model.Contato;
import model.Usuario;
import util.Mascara;

public class BuscarPorNome implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Usuario usuario = (Usuario) req.getAttribute("usuario");
		
		ContatoDAO contatoDao = (ContatoDAO) req.getAttribute("contatoDao");
		
		int totalElementos = contatoDao.totalElementos(usuario.getId());
		
		String pagina = req.getParameter("pagina");
		int paginaAtual = (pagina == null) ? 0: Integer.parseInt(pagina);
		
		String quantidade = req.getParameter("quantidade");
		int quantidadePorPagina = (quantidade == null) ? 4 : 
			Integer.parseInt(req.getParameter("quantidade"));
		
		PaginaComponent pg = new PaginaComponent(totalElementos,paginaAtual,quantidadePorPagina);
		
		String nome = req.getParameter("search");
		
		List<Contato> contatos = contatoDao.buscarPorNome(usuario.getId(), nome);
		
		contatos.forEach(contato -> {
			contato.setCelular(Mascara.mascaraCelular(contato.getCelular()));
			contato.setTelefone(Mascara.mascaraTelefone(contato.getTelefone()));
		});
		
		Pagina conteudoPaginado = pg.getPagina(contatos);
		
		req.setAttribute("pagina", conteudoPaginado);
		
		return "contato/listar.jsp";
		
	}

}
