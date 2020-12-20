package componentes.paginacao;

import java.util.List;

public class Pagina {
	
	private List<?> conteudo;
	private int totalElementos;
	private int totalElementosPagina;
	private int paginaAtual;
	private int quantidadePorPagina;
	private int totalPagina;
	private boolean primeiraPagina;
	private boolean ultimaPagina;
	
	public Pagina() {
		
	}

	public List<?> getConteudo() {
		return conteudo;
	}

	public void setConteudo(List<?> conteudo) {
		this.conteudo = conteudo;
	}

	public int getTotalElementos() {
		return totalElementos;
	}

	public void setTotalElementos(int totalElementos) {
		this.totalElementos = totalElementos;
	}

	public int getTotalElementosPagina() {
		return totalElementosPagina;
	}

	public void setTotalElementosPagina(int totalElementosPagina) {
		this.totalElementosPagina = totalElementosPagina;
	}

	public int getPaginaAtual() {
		return paginaAtual;
	}

	public void setPaginaAtual(int paginaAtual) {
		this.paginaAtual = paginaAtual;
	}

	public int getQuantidadePorPagina() {
		return quantidadePorPagina;
	}

	public void setQuantidadePorPagina(int quantidadePorPagina) {
		this.quantidadePorPagina = quantidadePorPagina;
	}

	public int getTotalPagina() {
		return totalPagina;
	}

	public void setTotalPagina(int totalPagina) {
		this.totalPagina = totalPagina;
	}

	public boolean getPrimeiraPagina() {
		return primeiraPagina;
	}

	public void setPrimeiraPagina(boolean primeiraPagina) {
		this.primeiraPagina = primeiraPagina;
	}

	public boolean getUltimaPagina() {
		return ultimaPagina;
	}

	public void setUltimaPagina(boolean ultimaPagina) {
		this.ultimaPagina = ultimaPagina;
	}

}
