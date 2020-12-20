package componentes.paginacao;

import java.util.List;

public class PaginaComponent {
	
	private int totalElementos;
	private int paginaAtual;
	private int quantidadePorPagina;
	
	public PaginaComponent(int totalElementos, int paginaAtual, int quantidadePorPagina) {
		super();
		this.totalElementos = totalElementos;
		this.paginaAtual = paginaAtual;
		this.quantidadePorPagina = quantidadePorPagina;
	}
	
	public int[] getLimites() {
		
		int[] limites = new int[2];
		
		limites[0] = this.paginaAtual * this.quantidadePorPagina;
		limites[1] = this.quantidadePorPagina;
		
		return limites;
	}
	
	public Pagina getPagina(List<?> conteudo){
		
		Pagina pagina = new Pagina();
		pagina.setConteudo(conteudo);
		pagina.setTotalElementos(this.totalElementos);
		pagina.setTotalElementosPagina(conteudo.size());
		pagina.setPaginaAtual(this.paginaAtual);
		pagina.setQuantidadePorPagina(this.quantidadePorPagina);
		pagina.setTotalPagina(this.getTotalPagina(this.totalElementos, this.quantidadePorPagina));
		pagina.setPrimeiraPagina(this.isPrimeiraPagina(paginaAtual));
		pagina.setUltimaPagina(this.isUltimaPagina(paginaAtual, pagina.getTotalPagina()));
		
		return pagina;
		
	}
	
	private int getTotalPagina(int totalElementos, int quantidadePorPagina) {
		
		int total = totalElementos / quantidadePorPagina;
		
		if(totalElementos % quantidadePorPagina != 0) {
			total += 1;
		}
		
		return total;
	}
	
	private boolean isPrimeiraPagina(int paginaAtual) {
		
		if(this.paginaAtual == 0) return true;
		
		return false;
		
	}
	
	private boolean isUltimaPagina(int paginaAtual, int totalPagina) {
		
		if((paginaAtual+1) == totalPagina) return true;
		
		return false;
		
	}
	

	public int getTotalElementos() {
		return totalElementos;
	}

	public void setTotalElementos(int totalElementos) {
		this.totalElementos = totalElementos;
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

}