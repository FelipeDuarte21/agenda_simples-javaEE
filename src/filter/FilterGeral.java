package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Conexao;

@WebFilter("/*")
public class FilterGeral implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		
		HttpSession session = req.getSession();

		if((uri.lastIndexOf("usuario")>-1) || (uri.lastIndexOf("login.jsp")>-1) || 
				(uri.lastIndexOf("/res")>-1) || (session.getAttribute("usuario") != null) ) {
			
			Connection conexao = Conexao.getConnection();
			
			request.setAttribute("conexao", conexao);
			
			chain.doFilter(request, response);
			
			try {
				conexao.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar conexão");
				e.printStackTrace();
			}
			
		}else {
			resp.sendRedirect("usuario?acao=login&opcao=1");
		}
		
	}

}
