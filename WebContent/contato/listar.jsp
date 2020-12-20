<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../cabecalho.jsp"></jsp:include>

	<style>
		.nao-quebra-tabela{
			white-space: nowrap;
		}
		.borda-card{
			border-left: 2px solid #007bff;
		}
	</style>

	<div class="container-xl">
		
		<div class="row justify-content-end">
		
			<div class="col col-md-4 mt-3">
				<span><i class="fas fa-user mr-1"></i>${usuario.nome}</span>
			    <a href="usuario?acao=logout" class="btn btn-sm btn-outline-secondary ml-1">
			    	<i class="fas fa-sign-out-alt mr-1"></i>Sair
			    </a>
			</div>
			
		</div>
		
		<div class="row mt-5 mt-md-3">
			
			<div class="col">
			
				<a href="contato?acao=cadastrar&opcao=1" class="btn btn-success">
					<i class="fas fa-plus mr-1"></i>Cadastrar
				</a>
				
				<ul class="nav nav-tabs mt-4">
				  <li class="nav-item">
				    <a class="nav-link active" data-toggle="pill" href="#cards">
				    	<i class="fas fa-id-card mr-1"></i>Cards
				    </a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link" data-toggle="pill" href="#tabela">
				    	<i class="fas fa-table mr-1"></i>Tabela
				    </a>
				  </li>
				</ul>
				<div class="tab-content mb-3">
					
				  <div class="my-3">
				  	
				  	<div class="row justify-content-center">
				  		
				  		<!-- Pesquisar por nome  -->
				  		<div class="col-12 col-md-4 text-center">
				  			
				  			<form action="contato" method="get" class="form-inline">
				  				
				  				<input type="hidden" name="acao" value="buscarPorNome">
				  				
				  				<input type="hidden" name="pagina" value="${pagina.paginaAtual}">
				  				
				  				<input type="hidden" name="quantidade" value="${pagina.quantidadePorPagina}">
				  				
				  				<input type="text" name="search" placeholder="digite o nome" class="form-control form-control-sm mr-1">
				  				
				  				<button type="submit" class="btn btn-primary btn-sm">
				  					<i class="fas fa-search mr-1"></i>Pesquisar
				  				</button>
				  			
				  			</form>
				  			
				  		
				  		</div>
				  		
				  		<!-- Paginação -->
				  		<div class="col-12 col-md-4 text-center">
				  			
				  			<c:if test="${!pagina.primeiraPagina}">
						  		<a href="contato?acao=listar&pagina=${pagina.paginaAtual-1}&quantidade=${pagina.quantidadePorPagina}"
						  			class="btn btn-outline-primary btn-sm mr-1">&laquo;</a>
						  	</c:if>
				  			
				  			<span>${pagina.paginaAtual+1} de ${pagina.totalPagina}</span>
				  			
				  			<c:if test="${!pagina.ultimaPagina}">
						  		<a href="contato?acao=listar&pagina=${pagina.paginaAtual+1}&quantidade=${pagina.quantidadePorPagina}" 
						  			class="btn btn-outline-primary btn-sm ml-1">&raquo;</a>
						  	</c:if>
				  		</div>
				  		
				  		<!-- Quantidade por pagina -->
				  		<div class="col-12 col-md-4">
				  		
				  			<form action="contato" method="get" class="form-inline justify-content-end">
				  				
				  				<input type="hidden" name="acao" value="listar">
				  				
				  				<input type="hidden" name="pagina" value="0">
				  				
				  				<label class="mr-2">Exibir:</label>	
				  				<select name="quantidade" class="form-control form-control-sm mr-1">
					  				<c:choose>
					  					<c:when test="${pagina.quantidadePorPagina == 4 }">
					  						<option value="4" selected="selected">4</option>
					  					</c:when>
					  					<c:when test="${pagina.quantidadePorPagina != 4}">
					  						<option value="4">4</option>
					  					</c:when>
					  				</c:choose>
					  				<c:choose>
					  					<c:when test="${pagina.quantidadePorPagina == 8}">
					  						<option value="8" selected="selected">8</option>
					  					</c:when>
					  					<c:when test="${pagina.quantidadePorPagina != 8}">
					  						<option value="8">8</option>
					  					</c:when>
					  				</c:choose>
					  				<c:choose>
					  					<c:when test="${pagina.quantidadePorPagina == 12}">
					  						<option value="12" selected="selected">12</option>
					  					</c:when>
					  					<c:when test="${pagina.quantidadePorPagina != 12}">
					  						<option value="12">12</option>
					  					</c:when>
					  				</c:choose>
				  				</select>
				  				
				  				<input type="submit" class="btn btn-sm" value="alterar">
				  				
				  			</form>
				  			
				  		</div>
				  		
				  	</div>
				  
				  </div>
				
				  <!-- Mostra Cards -->
				  <div class="tab-pane fade show active" id="cards">
				  	
				  	<div class="row mt-3">
				  	
				  		<c:forEach var="contato" items="${pagina.conteudo}">
				  		
				  		<div class="col-12 col-md-6 col-lg-4 col-xl-3 mt-2">
				  			
				  			<div class="card borda-card">
				  			
				  				<div class="card-header p-1">
				  					<h6 class="mb-0 ml-2 d-inline">#</h6>
				  					<span>${contato.id}</span>
				  				</div>
				  				
				  				<div class="card-body">
				  					
				  					<h6 class="mb-0">Nome</h6>
				  					<span>${contato.nome}</span>
				  					
				  					<h6 class="mb-0 mt-3">Celular</h6>
				  					<span>${contato.celular}</span>
				  					
				  					<h6 class="mb-0 mt-3">Telefone</h6>
				  					<span>${contato.telefone}</span>
				  					
				  					<h6 class="mb-0 mt-3">Email</h6>
				  					<span>${contato.email}</span>
				  				
				  				</div>
				  				
				  				<div class="card-footer">
				  					<a href="contato?acao=alterar&opcao=1&id=${contato.id}" class="btn btn-sm btn-info"
				  						data-toggle="tooltip" data-placement="bottom" title="Alterar contato">
						                  <i class="fas fa-edit"></i>
						            </a>
						            <a href="javascript:excluir(${contato.id})" class="btn btn-sm btn-danger"
						            	data-toggle="tooltip" data-placement="bottom" title="Excluir contato">
						                 <i class="fas fa-trash"></i>
						            </a>
				  				</div>
				  			
				  			</div>
				  			
				  		</div>
				  		
				  		</c:forEach>
				  	</div>
				  		
				  </div>
				  
				  <!-- Mostra Tabela -->
				  <div class="tab-pane fade" id="tabela">
				  
				  	<div class="table-responsive mt-4">
						<table class="table table-striped table-sm">
					        <thead>
					            <tr class="nao-quebra-tabela">
					                <th>#</th>
					                <th>Nome</th>
					                <th>Celular</th>
					                <th>Telefone</th>
					                <th>Email</th>
					                <th class="text-center">Opções</th>
					            </tr>
					        </thead>
					        <tbody>
					        	<c:forEach var="contato" items="${pagina.conteudo}" >
						        	 <tr class="nao-quebra-tabela">
						                <td>${contato.id}</td>
						                <td>${contato.nome}</td>
						                <td>${contato.celular}</td>
						                <td>${contato.telefone}</td>
						                <td>${contato.email}</td>
						                <td class="text-center">
						                    <a href="contato?acao=alterar&opcao=1&id=${contato.id}" class="btn btn-sm btn-info"
						                    	data-toggle="tooltip" data-placement="bottom" title="Alterar contato">
						                    	<i class="fas fa-edit"></i>
						                    </a>
						                    <a href="javascript:excluir(${contato.id})" class="btn btn-sm btn-danger"
						                    	data-toggle="tooltip" data-placement="bottom" title="Excluir contato">
						                    	<i class="fas fa-trash"></i>
						                    </a>
						                </td>
						            </tr>
					        	</c:forEach>   
					        </tbody>
					    </table>
					</div>
					
				  </div>
				
				</div>
				
			</div>
			
		</div>
		
	</div>
	
	<script>
		function excluir(id){
			if(confirm("Deseja realmente excluir o contato ?")){
				location.href = "contato?acao=excluir&id="+id;
			}
		}
	</script>

<jsp:include page="../rodape.jsp"></jsp:include>